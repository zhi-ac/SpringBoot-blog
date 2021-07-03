package cn.sheng.blog.mapper;

import cn.sheng.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    public int insertArticle(Article article);


    public Article getArticleById(int id);

    List<Article> getArticles();

    void deleteById(int id);

    boolean updateArticle(Article article);
}
