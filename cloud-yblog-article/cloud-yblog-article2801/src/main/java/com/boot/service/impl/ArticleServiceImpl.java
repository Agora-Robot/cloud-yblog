package com.boot.service.impl;

import com.boot.dao.ArticleMapper;
import com.boot.pojo.Article;
import com.boot.pojo.Statistic;
import com.boot.service.ArticleService;
import com.boot.service.CategoryService;
import com.boot.service.StatisticService;
import com.boot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * @author 游政杰
 */
@Service
@Transactional //事务控制
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StatisticService statisticService;


    //代码重构，修改文章
    @Override
    public void changeArticle_service(Article article) {

        try {
            //修改操作代码
            article.setCategories("默认分类");
//            categoryService.updateCategoryCount(article.getCategories());
            java.util.Date date1 = new java.util.Date();
            long time = date1.getTime();
            Date date = new Date(time);
//          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//          simpleDateFormat.format(date);
            article.setModified(date);

            //修改标签
            String pre_tags = articleService.selectTagsByArticleId(article.getId());
            String post_tags = article.getTags(); //修改之后的tags
            //1.先获取该文章的tags，对tag进行-1
            //2.再获取修改后的tags，对tag进行+1
            //3.再把post_tags覆盖到数据库的tags上
            String[] pre_split = pre_tags.split(",");
            String[] post_split = post_tags.split(",");

            for (String s : pre_split) {
                tagService.changeTagByTagNameDecr(s);
                redisTemplate.opsForValue().decrement("tag_" + s);
            }
//            //伪造异常，测试事务是否生效
//            String str = null;
//            char c = str.charAt(10);

            //如果没有这个某个标签，我们就把这个标签添加进去
            for (String s : post_split) {
                //通过redis判断有没有这个标签
                Integer o = (Integer) redisTemplate.opsForValue().get("tag_" + s);
                System.out.println("o====>" + o);
                if (o == null) {
                    //如果缓存中没有这个标签就添加
                    tagService.insertTag(s);
                    //添加完数据库之后，我们还要把数据添加到redis缓存中
                    redisTemplate.opsForValue().set("tag_" + s, 1);
                } else {
                    //如果缓存中有这个标签就+1
                    tagService.changeTagByTagNameIncr(s);
                    o++;
                    redisTemplate.opsForValue().set("tag_" + s, o);
                }

            }

            articleService.changeArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }


    }

    @Override
    public void publishArticle_service(Article article) {

        //发布操作代码
        try {
            article.setCategories("默认分类");
            categoryService.updateCategoryCount(article.getCategories());
            article.setAllowComment(true);
            java.util.Date date1 = new java.util.Date();
            Date date = new Date(date1.getTime());
            article.setCreated(date);
            articleService.addArticle(article); //开启了 keyProperty="id" useGeneratedKeys="true"，自动生成的主键id会保存在article.getId()里。
            statisticService.addStatistic(new Statistic(article.getId(), 0, 0));


            String tags = article.getTags();
            String[] post_split = tags.split(",");
            //如果没有这个某个标签，我们就把这个标签添加进去
            for (String s : post_split) {
                //通过redis判断有没有这个标签
                Integer o = (Integer) redisTemplate.opsForValue().get("tag_" + s);
                if (o == null) {
                    //如果缓存中没有这个标签就添加
                    tagService.insertTag(s);
                    //添加完数据库之后，我们还要把数据添加到redis缓存中
                    redisTemplate.opsForValue().set("tag_" + s, 1);
                } else {
                    //如果缓存中有这个标签就+1
                    tagService.changeTagByTagNameIncr(s);
                    o++;
                    redisTemplate.opsForValue().set("tag_" + s, o);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }


    }

    @Override
    public void deleteArticle_service(long id) {
        try {

            Article article = articleService.selectArticleByArticleIdNoComment(id);
            articleService.deleteArticleByArticleId(id);//删除文章
            statisticService.deleteStatisticByArticleId(id);//删除点击量

//            //伪造异常，测试事务是否生效
//            String str = null;
//            char c = str.charAt(10);

            categoryService.updateCategoryCountDecr(article.getCategories());//修改分类数
            //修改标签
            String tags = article.getTags();
            String[] split = tags.split(",");
            if (split != null && split.length > 0) {
                for (String s : split) {
                    tagService.changeTagByTagNameDecr(s); //把每个标签-1
                    redisTemplate.opsForValue().decrement("tag_" + s); //把redis标签数-1
                }
            }

        } catch (Exception e) {

            throw new RuntimeException();
        }


    }

    @Override
    public List<Article> selectArticleStatistic() {
        return articleMapper.selectArticleStatistic();
    }

    @Override
    public void updateRecommendTo_0(long id) {
        articleMapper.updateRecommendTo_0(id);
    }

    @Override
    public void updateRecommendTo_1(long id) {
        articleMapper.updateRecommendTo_1(id);

    }

    @Override
    public List<Article> selectArticleByRecommend() {
        return articleMapper.selectArticleByRecommend();
    }

    @Override
    public int selectLikeCount(long articleid) {
        return articleMapper.selectLikeCount(articleid);
    }

    @Override
    public void likeCountAddOne(long articleid) {
        articleMapper.likeCountAddOne(articleid);
    }

    @Override
    public List<Article> queryArticleByTitle(String title) {
        return articleMapper.queryArticleByTitle(title);
    }

    @Override
    public int queryArticleByTitleCount(String title) {
        return articleMapper.queryArticleByTitleCount(title);
    }

    @Override
    public List<Article> queryArticleByCategoryName(String categoryName) {
        return articleMapper.queryArticleByCategoryName(categoryName);
    }


    @Override
    public List<Article> selectAllArticle() {
        return articleMapper.selectAllArticle();
    }

    @Override
    public Article selectArticleByArticleIdNoComment(long id) {
        return articleMapper.selectArticleByArticleIdNoComment(id);
    }

    @Override
    public List<Article> selectAllArticleOrderByDesc() {
        return articleMapper.selectAllArticleOrderByDesc();
    }

    @Override
    public int selectArticleCount() {
        return articleMapper.selectArticleCount();
    }

    @Override
    public List<Article> selectAllArticleByCreated() {
        return articleMapper.selectAllArticleByCreated();
    }

    @Override
    public int changeArticle(Article article) {
        return articleMapper.changeArticle(article);
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public int deleteArticleByArticleId(long id) {
        return articleMapper.deleteArticleByArticleId(id);
    }

    @Override
    public void updateHits(long article_id) {
        articleMapper.updateHits(article_id);
    }

    @Override
    public List<Article> selectCategoriesAndTags() {
        return articleMapper.selectCategoriesAndTags();
    }

    @Override
    public List<Article> selectTagsByArticle() {
        return articleMapper.selectTagsByArticle();
    }

    @Override
    public String selectTagsByArticleId(long id) {
        return articleMapper.selectTagsByArticleId(id);
    }

    @Override
    public void updateTagsByArticleId(String tags, long id) {
        articleMapper.updateTagsByArticleId(tags, id);
    }

    @Override
    public void updateCategory(String oldName, String newName) {
        articleMapper.updateCategory(oldName, newName);
    }

    @Override
    public void updateAllowCommentTo_0(long id) {
        articleMapper.updateAllowCommentTo_0(id);
    }

    @Override
    public void updateAllowCommentTo_1(long id) {
        articleMapper.updateAllowCommentTo_1(id);
    }


}
