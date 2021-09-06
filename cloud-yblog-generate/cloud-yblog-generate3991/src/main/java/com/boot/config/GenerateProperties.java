package com.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "cloud.yblog.generate")
@Configuration
public class GenerateProperties {

    private boolean generateModel; //是否生成实体类
    private boolean modelSerialize; //实体类是否序列化
    private boolean modelGetterAndSetter; //是否生成get/set方法
    private boolean modelConstructor; //是否生成构造方法
    private String modelPackage; //存放生成的实体类的包名（后面会和generateModelPath+modelPackage进行拼接作为路径）
    private String generateModelPath; //生成实体类的路径（**默认使用这个路径**）


    public boolean getGenerateModel() {
        return generateModel;
    }

    public void setGenerateModel(boolean generateModel) {
        this.generateModel = generateModel;
    }

    public boolean getModelSerialize() {
        return modelSerialize;
    }

    public void setModelSerialize(boolean modelSerialize) {
        this.modelSerialize = modelSerialize;
    }

    public boolean getModelGetterAndSetter() {
        return modelGetterAndSetter;
    }

    public void setModelGetterAndSetter(boolean modelGetterAndSetter) {
        this.modelGetterAndSetter = modelGetterAndSetter;
    }

    public boolean getModelConstructor() {
        return modelConstructor;
    }

    public void setModelConstructor(boolean modelConstructor) {
        this.modelConstructor = modelConstructor;
    }



    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getGenerateModelPath() {
        return generateModelPath;
    }

    public void setGenerateModelPath(String generateModelPath) {
        this.generateModelPath = generateModelPath;
    }

    @Override
    public String toString() {
        return "GenerateProperties{" +
                "generateModel=" + generateModel +
                ", modelSerialize=" + modelSerialize +
                ", modelGetterAndSetter=" + modelGetterAndSetter +
                ", modelConstructor=" + modelConstructor +
                ", modelPackage='" + modelPackage + '\'' +
                ", generateModelPath='" + generateModelPath + '\'' +
                '}';
    }
}
