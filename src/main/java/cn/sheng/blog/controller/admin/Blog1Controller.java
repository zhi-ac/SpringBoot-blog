package cn.sheng.blog.controller.admin;

import cn.sheng.blog.pojo.Article;
import cn.sheng.blog.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Blog1Controller {

    private final ArticleServiceImpl articleService;


    @Autowired
    public Blog1Controller(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/blog/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", articleService.getArticleById(id));
//        return "redirect:/admin/update";
        return "admin/blog-input";
    }
}
