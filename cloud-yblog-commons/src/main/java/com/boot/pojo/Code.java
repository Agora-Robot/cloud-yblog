package com.boot.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel("自动生成代码的存放类")
public class Code implements Serializable {

    private String className; //类名
    private List<String> attributes; //格式为:属性,对象
    private String databaseName; //数据库名
    private String primaryKey; //主键

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Code{" +
                "className='" + className + '\'' +
                ", attributes=" + attributes +
                ", databaseName='" + databaseName + '\'' +
                ", primaryKey='" + primaryKey + '\'' +
                '}';
    }
}
