package com.boot.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel(value = "权限实体类",description = "封装权限")
public class Authority implements Serializable {

    private long id;
    private String authority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
