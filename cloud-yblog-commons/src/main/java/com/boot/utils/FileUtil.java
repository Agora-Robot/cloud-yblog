package com.boot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.UUID;

@Component
public final class FileUtil {


    private static RedisTemplate redisTemplate;

    @Autowired
    public  void setRedisTemplate(RedisTemplate redisTemplate) {
        FileUtil.redisTemplate = redisTemplate;
    }

    /**
     * 文件工具类
     *
     * @return
     */

    //获取文件后缀名（会转换成小写）
    public static final String getFileSuffix(String originalFilename){

        //获取头像后缀名 ,采用导入遍历，遇到“.”就break ，保存后缀名
        StringBuilder stringBuilder=new StringBuilder();
        for (int x=originalFilename.length()-1;x>=0;x--){
            if(originalFilename.charAt(x)=='.'){
                break;
            }else {
                stringBuilder.append(originalFilename.charAt(x));
            }
        }
        //因为上面获取的后缀名是倒序的，所以我们要反转字符串
        String post="";
        String s = stringBuilder.toString();
        for (int i = s.length()-1; i >=0 ; i--) {
            post+=s.charAt(i);
        }
        //后缀名变成小写
        String post_lower = post.toLowerCase();


        return post_lower;

    }

    public static final String getRandomName(){
        String s = UUID.randomUUID().toString();
        String s1 = s.replaceAll("-", "");
        return s1;
    }

    //获取静态路径
    public static final String getStaticPath() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:static").getPath();
        String substring = path.substring(1, path.length());
        return substring;
    }

    //因为图片是存储在web模块的target中，所以如果我们之前调用上面的方法获取路径是不行的，所以要从缓存获取
    //web模块在启动时会把路径放到redis中
    public static final String getStaticPathByRedis(){

        String staticPath = (String) redisTemplate.opsForValue().get("staticPath");

        return staticPath;
    }

    //获取大图文件夹路径
    public static final String getBigImgPath() throws FileNotFoundException {
        String staticPath = getStaticPathByRedis();
        staticPath+="/big_img/";
        return staticPath;
    }

    //获取缩略图文件夹路径
    public static final String getSmallImgPath() throws FileNotFoundException {
        String staticPath = getStaticPathByRedis();
        staticPath+="/small_img/";
        return staticPath;
    }


    public static final void write(String path,byte[] fileByteArray) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        bufferedOutputStream.write(fileByteArray);


        bufferedOutputStream.flush(); //刷新缓冲区
        bufferedOutputStream.close();
        fileOutputStream.close();
    }


    //获取用户头像所在地址
    public static final String writeImage(String originalFilename, byte[] fileByteArray) throws IOException {

        String staticPath = FileUtil.getStaticPathByRedis();

        String usericonPath_datebase="/user_img/"; //存入数据库的地址
        String randomName = FileUtil.getRandomName();
        String fileSuffix = FileUtil.getFileSuffix(originalFilename); //获取文件后缀名
        String fileName=randomName+"."+fileSuffix;
        usericonPath_datebase+=fileName;


        staticPath+=usericonPath_datebase;

        //写文件
        write(staticPath,fileByteArray);

        return usericonPath_datebase; //返回需要存储到数据库的图片地址
    }


    //获取logo所在地址
    public static final String writeImageLogo(String originalFilename, byte[] fileByteArray) throws IOException {

        String staticPath = FileUtil.getStaticPathByRedis();

        String usericonPath_datebase="/user/img/"; //存入数据库的地址
        String randomName = FileUtil.getRandomName();
        String fileSuffix = FileUtil.getFileSuffix(originalFilename); //获取文件后缀名
        String fileName=randomName+"."+fileSuffix;
        usericonPath_datebase+=fileName;


        staticPath+=usericonPath_datebase;

        //写文件
        write(staticPath,fileByteArray);

        return usericonPath_datebase; //返回需要存储到数据库的图片地址
    }



}
