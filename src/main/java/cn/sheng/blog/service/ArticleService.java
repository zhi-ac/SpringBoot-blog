package cn.sheng.blog.service;

import cn.sheng.blog.pojo.Article;

public interface ArticleService {
    public boolean publishArticle(Article article) ;

    void deleteById(int id);
    public boolean updateArticle(Article article);
}
