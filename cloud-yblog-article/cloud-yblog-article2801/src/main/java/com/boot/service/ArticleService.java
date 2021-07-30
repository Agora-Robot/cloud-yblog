package com.boot.service;

import com.boot.pojo.Article;

import java.util.List;

/**
 * @author 游政杰
 */
public interface ArticleService {

    public List<Article> selectAllArticle();

    public Article selectArticleByArticleIdNoComment(Integer id);

    //排行榜
    public List<Article> selectAllArticleOrderByDesc();

    public List<Article> selectArticleAndComment();

    public List<Article> selectArticleOrderCreateDate();

    public int selectArticleCount();

    public List<Article> selectAllArticleByCreated();

    public int changeArticle(Article article);

    public int addArticle(Article article);

    public int deleteArticleByArticleId(Integer id);

    //当用户点击文章时，文章点击数加1
    public void updateHits(Integer article_id);

    public List<Article> selectCategoriesAndTags();

    public List<Article> selectTagsByArticle();

    public String selectTagsByArticleId(int id);

    public void updateTagsByArticleId(String tags, int id);

    public void updateCategory(String oldName, String newName);

    //是否可以评论功能
    //变成0
    void updateAllowCommentTo_0(int id);
    //变成1
    void updateAllowCommentTo_1(int id);


    /**
     * 代码重构
     */
    void changeArticle_service(Article article);


    void publishArticle_service(Article article);

    void deleteArticle_service(Integer id);

    //echarts
    List<Article> selectArticleStatistic();

    //修改是否推荐
    void updateRecommendTo_0(int id);

    void updateRecommendTo_1(int id);

    //查询推荐的文章
    List<Article> selectArticleByRecommend();

    //查询文章点赞数
    int selectLikeCount(int articleid);

    //点赞总数加1
    void likeCountAddOne(int articleid);

    //按title查询文章
    List<Article> queryArticleByTitle(String title);

    //查询指定文章title有多少篇文章
    int queryArticleByTitleCount(String title);

    List<Article> queryArticleByCategoryName(String categoryName);
}
