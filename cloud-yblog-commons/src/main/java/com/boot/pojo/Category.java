package com.boot.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel(value = "分类实体类",description = "封装分类信息")
public class Category implements Serializable {

    private long id;
    private String categoryName;
    private int categoryCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(int categoryCount) {
        this.categoryCount = categoryCount;
    }

    @Override
    public String toString() {
        return "category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCount=" + categoryCount +
                '}';
    }
}
