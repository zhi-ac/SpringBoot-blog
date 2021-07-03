package cn.sheng.blog.controller;

import cn.sheng.blog.pojo.Article;
import cn.sheng.blog.service.ReadService;
import cn.sheng.blog.utils.MarkDownToHtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReadController {

    @Autowired
    ReadService readService;

    @GetMapping("/read/{id}")
    public String toRead(@PathVariable(name = "id") int id, Model model) {
        Article article = readService.getArticleById(id);
        article.setContent(MarkDownToHtmlUtils.markdownToHtmlExtensions(article.getContent()));
        article.setDescription(MarkDownToHtmlUtils.markdownToHtmlExtensions(article.getDescription()));
        model.addAttribute("article", article);
        return "read";
    }
}
