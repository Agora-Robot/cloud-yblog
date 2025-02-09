package com.boot.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel(value = "用户详情实体类", description = "封装了用户详情")
public class UserDetail implements Serializable {

    private long id; //id
    private String name; //用户名
    private String blogName;//博客名称
    private String job; //工作
    private String detail; //详情
    private String github; //GitHub地址
    private String weibo; //微博地址
    private String icon; //用户头像地址

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogName='" + blogName + '\'' +
                ", job='" + job + '\'' +
                ", detail='" + detail + '\'' +
                ", github='" + github + '\'' +
                ", weibo='" + weibo + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
