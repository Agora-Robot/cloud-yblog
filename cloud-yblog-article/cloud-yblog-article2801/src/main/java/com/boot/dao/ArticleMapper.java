package com.boot.dao;

import com.boot.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    public List<Article> selectAllArticle();

    //只查询article，不查询Comment
    public Article selectArticleByArticleIdNoComment(@Param("id") Integer id);

    //排行榜
    public List<Article> selectAllArticleOrderByDesc();

    public int selectArticleCount();

    public List<Article> selectAllArticleByCreated();

    public int changeArticle(Article article);

    public int addArticle(Article article);

    public int deleteArticleByArticleId(@Param("id") Integer id);

    //当用户点击文章时，文章点击数加1
    public void updateHits(@Param("article_id") Integer article_id);

    public List<Article> selectCategoriesAndTags();

    public List<Article> selectTagsByArticle();

    public String selectTagsByArticleId(@Param("id") long id);

    public void updateTagsByArticleId(@Param("tags") String tags, @Param("id") int id);

    public void updateCategory(@Param("oldName") String oldName, @Param("newName") String newName);

    //是否可以评论功能
    //变成0
    void updateAllowCommentTo_0(@Param("id") int id);

    //变成1
    void updateAllowCommentTo_1(@Param("id") int id);

    //echarts
    List<Article> selectArticleStatistic();


    //修改是否推荐
    void updateRecommendTo_0(@Param("id") int id);

    void updateRecommendTo_1(@Param("id") int id);

    //查询推荐的文章
    List<Article> selectArticleByRecommend();

    //查询文章点赞数
    int selectLikeCount(@Param("articleid") long articleid);

    //点赞总数加1
    void likeCountAddOne(@Param("articleid") long articleid);


    //按title查询文章
    List<Article> queryArticleByTitle(@Param("title") String title);

    //查询指定文章title有多少篇文章
    int queryArticleByTitleCount(@Param("title") String title);

    @Select("select id,title from t_article where categories=#{categoryName}")
    List<Article> queryArticleByCategoryName(String categoryName);


}
