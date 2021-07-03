package cn.sheng.blog.service.impl;

import cn.sheng.blog.mapper.ArticleMapper;
import cn.sheng.blog.pojo.Article;
import cn.sheng.blog.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadServiceImpl implements ReadService {

    private final ArticleMapper articleMapper;

    @Autowired
    public ReadServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public Article getArticleById(int id) {
        Article article = articleMapper.getArticleById(id);
        return article;
    }
}
