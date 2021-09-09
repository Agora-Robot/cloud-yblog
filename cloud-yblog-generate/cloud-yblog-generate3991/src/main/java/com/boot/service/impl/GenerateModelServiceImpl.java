package com.boot.service.impl;

import com.boot.config.GenerateProperties;
import com.boot.pojo.Code;
import com.boot.service.GenerateModelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

/** @author 游政杰 */
@Service
@Slf4j
public class GenerateModelServiceImpl implements GenerateModelService {

  @Autowired private GenerateProperties generateProperties;

  private FileOutputStream fileOutputStream = null;
  private BufferedOutputStream bufferedOutputStream = null;

  @Override
  public boolean generate(Code code) {

    try {

      log.info("加载配置文件内容......");
      boolean generateModel = generateProperties.getGenerateModel();
      boolean modelSerialize = generateProperties.getModelSerialize();
      boolean modelGetterAndSetter = generateProperties.getModelGetterAndSetter();
      boolean modelConstructor = generateProperties.getModelConstructor();
      String generatePackage = generateProperties.getGeneratePackage();
      String generateModelPath = generateProperties.getGenerateModelPath();
      boolean generateDatabase = generateProperties.getGenerateDatabase();
      String databaseHost = generateProperties.getDatabaseHost();
      int databasePort = generateProperties.getDatabasePort();
      String databaseUser = generateProperties.getDatabaseUser();
      String databasePassword = generateProperties.getDatabasePassword();
      String databaseDriver = generateProperties.getDatabaseDriver();
      boolean generateTable = generateProperties.getGenerateTable();
      boolean generateMapper = generateProperties.getGenerateMapper();
      boolean generateMapperXml = generateProperties.getGenerateMapperXml();
      boolean generateServiceAndImpl = generateProperties.getGenerateServiceAndImpl();

      // 如果需要生成实体类
      if (generateModel) {
        log.info("正在自动生成实体类......");

        generateModel(
            code,
            modelSerialize,
            modelGetterAndSetter,
            modelConstructor,
            generatePackage,
            generateModelPath);
        log.info("生成实体类成功......");
      }

      // 如果需要生成数据库
      if (generateDatabase) {

        log.info("正在生成数据库......");
        generateDatabase(
            code, databaseHost, databasePort, databaseUser, databasePassword, databaseDriver);

        log.info("生成数据库成功......");
      }


      //如果需要生成数据库表
      if(generateTable){

        log.info("正在生成数据库表......");
        generateTable(code,databaseHost, databasePort, databaseUser, databasePassword, databaseDriver);
        log.info("生成数据库表成功......");
      }



      return true;
    } catch (Exception e) {
      log.info("自动生成代码出现异常,生成失败......");

      return false;
    }
  }

  //自动生成数据库表
  private void generateTable(Code code, String databaseHost, int databasePort, String databaseUser, String databasePassword, String databaseDriver) throws ClassNotFoundException, SQLException {

    ResourceBundle mysqlDataType = ResourceBundle.getBundle("mysqlDataType");

    Class.forName(databaseDriver);

    String urlArgs = "?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8"; // url参数

    String databaseName=code.getDatabaseName();
    String url = "jdbc:mysql://" + databaseHost + ":" + databasePort + "/"+databaseName + urlArgs;
    Connection connection = DriverManager.getConnection(url, databaseUser, databasePassword);

    Statement statement = connection.createStatement();

    String tableName="t_"+code.getClassName(); //数据库表名（默认）
    StringBuffer stringBuffer = new StringBuffer(); //拼接创建表的sql

    stringBuffer.append("CREATE TABLE `"+tableName+"` (");

    List<String> attributes = code.getAttributes();

    for (int i = 0; i < attributes.size(); i++) {
      String[] data = parseData(attributes.get(i));
      String dataType = data[0];
      String dataObject = data[1];
      String type = dataType.toLowerCase(); //变小写
      String sqlDataType = mysqlDataType.getString(type); //获取配置文件中的javaType对应的sqlType
      if(StringUtils.isBlank(sqlDataType)){ //如果查询不到类型，直接抛异常
        log.error("无法从配置文件中查询到字段的类型,生成数据库表失败......");
        throw new RuntimeException("无法从配置文件中查询到字段的类型,生成数据库表失败......");
      }
      stringBuffer.append("`"+dataObject+"` "+sqlDataType+" ,");

    }
    stringBuffer.append("PRIMARY KEY (`"+code.getPrimaryKey()+"`)"); //添加主键
    stringBuffer.append(")ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");


    String sql = stringBuffer.toString();
    int res = statement.executeUpdate(sql);

    log.info("执行创建表成功：res="+res);

  }

  // 自动生成数据库
  private void generateDatabase(
      Code code,
      String databaseHost,
      int databasePort,
      String databaseUser,
      String databasePassword,
      String databaseDriver)
      throws ClassNotFoundException, SQLException {

    // 加载数据库驱动
    Class.forName(databaseDriver);

    String databaseName = code.getDatabaseName(); // 获取需要生成的数据库名

    String sql = "create database " + databaseName + ";";

    String urlArgs = "?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8"; // url参数

    String url = "jdbc:mysql://" + databaseHost + ":" + databasePort + "/cloud_yblog_log" + urlArgs;
    Connection connection = DriverManager.getConnection(url, databaseUser, databasePassword);

    Statement statement = connection.createStatement();

    int res=statement.executeUpdate(sql); // 创建数据库

    log.info("---------statement-executeUpdate--创建数据库："+res);
  }

  // 自动生成实体类
  private void generateModel(
      Code code,
      boolean modelSerialize,
      boolean modelGetterAndSetter,
      boolean modelConstructor,
      String generatePackage,
      String generateModelPath)
      throws IOException {

    try {

      // 使用StringBuffer来写自动生成的代码
      // StringBuilder也行，但是StringBuffer的优势是在多线程的情况下使用的，刚好我们现在的场景符合。
      StringBuffer codeString = new StringBuffer();

      String[] split = generatePackage.split("\\."); // ***split之间分隔'.'是没有用的,要"\\."

      String packageName = split[split.length - 1];

      String modelPackagePath = generateModelPath + "\\" + packageName + "\\pojo"; // 实体类的包路径

      File pg = new File(modelPackagePath);

      // 创建包的操作
      if (!pg.exists()) { // 如果实体类的包不存在，则创建一个

        boolean mkdir = pg.mkdir();

      } else {

        if (pg.isFile()) {
          boolean delete = pg.delete();
        }
      }

      String className = code.getClassName(); // 类名

      String modelClassPath = modelPackagePath + "\\" + className + ".java"; // 类的路径**

      List<String> attributes = code.getAttributes(); // 获取属性,对象

      // 写代码生成文件
      codeString.append("package " + generatePackage + ".pojo;\n\n");

      // 写导入类
      codeString.append("import lombok.ToString;\n");
      codeString.append("import java.util.*;\n"); // 导入java.util包

      if (modelSerialize) { // 如果需要序列化
        codeString.append("import java.io.Serializable;\n");
      }

      // 写入代码生成注释信息
      codeString.append("\n\n/**\n");
      codeString.append(" * 该类由cloud-yblog内置的代码器生成\n");

      Date date = new Date();
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String dateTime = simpleDateFormat.format(date);

      codeString.append(" * @date " + dateTime + "\n */\n");

      // 写入注释完成

      // 开始写入类

      // 生成lombok的@ToString注解
      codeString.append("@ToString //lombok生成toString方法\n");

      if (modelSerialize) {

        codeString.append("public class " + className + " implements Serializable {");

      } else {

        codeString.append("public class " + className + " {");
      }

      // 生成字段
      for (int i = 0; i < attributes.size(); i++) {
        String[] data = parseData(attributes.get(i));
        String dataType = data[0];
        String dataObject = data[1];

        codeString.append("\n\tprivate " + dataType + " " + dataObject + ";");
      }

      codeString.append("\n\n");

      if (modelConstructor) { // 如果生成构造方法

        // 写入无參构造
        codeString.append("\t//无參构造方法\n");
        codeString.append("\tpublic " + className + "(){\n\t}");

        // 写入有参构造
        codeString.append("\n\n\tpublic " + className + "(");

        for (int i = 0; i < attributes.size() - 1; i++) {
          String[] data = parseData(attributes.get(i));
          String dataType = data[0];
          String dataObject = data[1];
          codeString.append(dataType + " " + dataObject + ", ");
        }

        String[] data1 = parseData(attributes.get(attributes.size() - 1));
        String dataType1 = data1[0];
        String dataObject1 = data1[1];
        codeString.append(dataType1 + " " + dataObject1 + ") {\n");

        for (int i = 0; i < attributes.size(); i++) {
          String[] data = parseData(attributes.get(i));
          String dataType = data[0];
          String dataObject = data[1];
          codeString.append("\t\tthis." + dataObject + " = " + dataObject + ";\n");
        }
        codeString.append("\t}\n\n\n");
      }

      if (modelGetterAndSetter) { // 如果生成getter/setter方法

        for (int i = 0; i < attributes.size(); i++) {
          String[] data = parseData(attributes.get(i));
          String dataType = data[0];
          String dataObject = data[1];

          // dataObject首字母大写
          String parseDataObject = "";

          // 如果首字母是大写则不用parse

          char c = dataObject.charAt(0); // 获取首字母字符
          if (c >= 97 && c <= 122) { // 说明首字母是小写，要parse

            for (int j = 0; j < dataObject.length(); j++) {
              if (j == 0) {
                parseDataObject += (char) (c - 32);
              } else {
                parseDataObject += dataObject.charAt(j);
              }
            }
            // get方法
            codeString.append("\tpublic " + dataType + " get" + parseDataObject + "() {\n");
            codeString.append("\t\treturn " + dataObject + ";\n\t}\n\n");
            // set方法
            codeString.append(
                "\tpublic void set"
                    + parseDataObject
                    + "("
                    + dataType
                    + " "
                    + dataObject
                    + ") {\n");
            codeString.append("\t\tthis." + dataObject + " = " + dataObject + ";\n\t}\n\n");

          } else { // 不用转换
            // get方法
            codeString.append("\tpublic " + dataType + " get" + dataObject + "() {\n");
            codeString.append("\t\treturn " + dataObject + ";\n\t}\n\n");
            // set方法
            codeString.append(
                "\tpublic void set" + dataObject + "(" + dataType + " " + dataObject + ") {\n");
            codeString.append("\t\tthis." + dataObject + " = " + dataObject + ";\n\t}\n\n");
          }
        }
      }

      // 类的结束
      codeString.append("\n}");

      // 生成文件
      fileOutputStream = new FileOutputStream(modelClassPath);
      bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

      String codeStr = codeString.toString();
      byte[] classToBytes = codeStr.getBytes();

      bufferedOutputStream.write(classToBytes);

      bufferedOutputStream.flush(); // 刷新缓冲区

    } catch (Exception e) {
      log.error("实体类代码生成失败...");
      throw new RuntimeException("实体类代码生成失败...");

    } finally {

      if (bufferedOutputStream != null) {
        bufferedOutputStream.close();
      }
      if (fileOutputStream != null) {
        fileOutputStream.close();
      }
    }
  }

  public String[] parseData(String data) {

    String[] split = data.split(",");

    return split;
  }
}
