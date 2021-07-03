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
@RequestMapping("/admin")
public class BlogController {

    private final ArticleServiceImpl articleService;


    @Autowired
    public BlogController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/blog/{id}/input")
    public String toUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", articleService.getArticleById(id));
//        return "redirect:/admin/update";
        return "admin/blog-input";
    }


    @GetMapping("/blogs")
    public String blogs(Model model) {
        List<Article> articles = articleService.getArticles();
        model.addAttribute("articles", articles);
        return "admin/blogs";
    }
    @GetMapping("/update")
    public String edit() {
        return "admin/edit";
    }
}
