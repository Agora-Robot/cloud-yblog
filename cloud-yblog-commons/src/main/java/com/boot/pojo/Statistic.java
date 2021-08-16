package com.boot.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 文章相关动态数据统计实体类
 * */
@ApiModel(value = "文章数据统计实体类",description = "封装每个文章的点击量和评论量")
public class Statistic implements Serializable {
    private long id;
    private long articleId;   // 评论的文章id
    private Integer hits;        // 点击量

    public Statistic() {
    }

    public Statistic(long id, long articleId, Integer hits) {
        this.id = id;
        this.articleId = articleId;
        this.hits = hits;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", hits=" + hits +
                '}';
    }
}
