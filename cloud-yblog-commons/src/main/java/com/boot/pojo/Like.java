package com.boot.pojo;

import io.swagger.annotations.ApiModel;

@ApiModel("文章点赞")
public class Like {

    private long id;
    private String username; //点赞的用户名
    private long article_id; //点赞的文章id


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", article_id=" + article_id +
                '}';
    }
}
