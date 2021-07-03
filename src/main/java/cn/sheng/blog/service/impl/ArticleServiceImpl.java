package cn.sheng.blog.service.impl;

import cn.sheng.blog.mapper.ArticleMapper;
import cn.sheng.blog.pojo.Article;
import cn.sheng.blog.service.ArticleService;
import cn.sheng.blog.utils.MarkDownToHtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public boolean publishArticle(Article article) {
//        article.setContent(MarkDownToHtmlUtils.markdownToHtmlExtensions(article.getContent()));
//        article.setDescription(MarkDownToHtmlUtils.markdownToHtmlExtensions(article.getDescription()));
        int res = articleMapper.insertArticle(article);
        if(res > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteById(int id) {
        articleMapper.deleteById(id);
    }


    public Article getArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

    public List<Article> getArticles() {
        return articleMapper.getArticles();
    }

    public boolean updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }
}
