package com.boot.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel(value = "友链",description = "友情链接")
public class Link implements Serializable {

    private long id;
    private String title;
    private String link;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
