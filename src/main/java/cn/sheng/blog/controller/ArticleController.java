package cn.sheng.blog.controller;

import cn.sheng.blog.pojo.Article;
import cn.sheng.blog.service.impl.ArticleServiceImpl;
import cn.sheng.blog.utils.FileUtils;
import cn.sheng.blog.utils.MarkDownToHtmlUtils;
import cn.sheng.blog.vo.ArticleVo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Value("${file.upload.editpicturePath}")
    private String editPicturePath;

    @Value("${file.upload.path}")
    private String filePath;

    private final ArticleServiceImpl articleService;

    @Autowired
    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        articleService.deleteById(id);
        return "redirect:/admin/blogs";
    }


    @GetMapping("/index")
    public String toIndex() {
        return "index";
    }



    @RequestMapping("/update")
    public String updateArticle(@RequestParam("id") int id, @RequestParam("title") String title, @RequestParam("author") String author,
                                 @RequestParam("content") String content, @RequestParam("picture") MultipartFile picture, @RequestParam("picturePath") String picturePath) throws IOException {
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setAuthor(author);
        article.setContent(content);
        article.setDescription(content.substring(0, content.length() <= 100 ? content.length() : 100));
        article.setDate(new Date());
        if(picture.getSize() != 0) {
            //"2"说明上传的是首图
            picturePath = FileUtils.uploadFile(picture, filePath, 2);
            System.out.println(picturePath);
        }
        article.setPicture(picturePath);
        boolean res = articleService.updateArticle(article);
        if(res) {
            return "redirect:/admin/blogs";
        }
        return "redirect:/admin/blogs";
    }


    @RequestMapping("/publish")
    public String publishArticle(@RequestParam("title") String title, @RequestParam("author") String author,
                                 @RequestParam("content") String content, @RequestParam("picture") MultipartFile picture) throws IOException {
        System.out.println(filePath);
//        BeanUtils.copyProperties(articleVo, article);
//        MultipartFile picture = articleVo.getPicture();
//        System.out.println(picture.getOriginalFilename());
        Article article = new Article();
        article.setTitle(title);
        article.setAuthor(author);
        article.setContent(content);
        article.setDescription(content.substring(0, content.length() <= 100 ? content.length() : 100));
        article.setDate(new Date());
        System.out.println(picture.getSize());
        //2说明上传的是首图
        String indexPicture = FileUtils.uploadFile(picture, filePath, 2);
//        String originalFilename = picture.getOriginalFilename();

        System.out.println(picture.getOriginalFilename());
        System.out.println(indexPicture);
        article.setPicture(indexPicture);
//        if (!picture.isEmpty()) {
//            UUID uuid = UUID.randomUUID();
//            String s = uuid.toString();

//            originalFilename = s + originalFilename;
//            article.setPicture(originalFilename);
//            picture.transferTo(new File(filePath + originalFilename));
//        }
        boolean res = articleService.publishArticle(article);
        if(res) {
            return "redirect:/admin/blogs";
        }
        return "redirect:/index";
    }
   /* @RequestMapping("/publish")
    public String publishArticle(ArticleVo articleVo) {
        Article article = new Article();
        BeanUtils.copyProperties(articleVo, article);
        MultipartFile picture = articleVo.getPicture();
        System.out.println(picture.getOriginalFilename());
        article.setDescription(article.getContent().substring(0, article.getContent().length() <= 100 ? article.getContent().length() : 100));
        boolean res = articleService.publishArticle(article);
        if(res) {
            return "redirect:/article/articles";
        }
        return "redirect:/index";
    }*/


    @RequestMapping("/image/upload")
    @ResponseBody
    public JSONObject imageUpload(@RequestPart("editormd-image-file") MultipartFile image) {
        JSONObject jsonObject = new JSONObject();
        if(image != null) {
//            String path = FileUtils.uploadFile(image);
            String path = FileUtils.uploadFile(image, editPicturePath, 1);
            System.out.println(path);
            jsonObject.put("url", path);
            jsonObject.put("success", 1);
            jsonObject.put("message", "upload success!");
            return jsonObject;
        }
        jsonObject.put("success", 0);
        jsonObject.put("message", "upload error!");
        return jsonObject;
    }

    /*@RequestMapping("/image/upload")
    @ResponseBody
    public JSONObject imageUpload(@RequestPart("editormd-image-file") MultipartFile image) {
        JSONObject jsonObject = new JSONObject();
        if(image != null) {
//            String path = FileUtils.uploadFile(image);
            String path = FileUtils.uploadFile(image);
            System.out.println(path);
            jsonObject.put("url", path);
            jsonObject.put("success", 1);
            jsonObject.put("message", "upload success!");
            return jsonObject;
        }
        jsonObject.put("success", 0);
        jsonObject.put("message", "upload error!");
        return jsonObject;
    }*/


    //测试用的，没其他作用
    @RequestMapping("/get/{id}")
    public ModelAndView getArticleById(@PathVariable(name = "id")int id) {
        ModelAndView modelAndView = new ModelAndView();
        Article article = articleService.getArticleById(id);
        modelAndView.setViewName("article-test");
        if(article == null) {
            modelAndView.addObject("article", new Article());
        }
        modelAndView.addObject("article", article);
        return modelAndView;
    }

    @GetMapping("/articles")
    public String getArticles(Model model) {

        List<Article> articles = articleService.getArticles();
        for (Article article : articles) {
            article.setContent(MarkDownToHtmlUtils.markdownToHtmlExtensions(article.getContent()));
            article.setDescription(MarkDownToHtmlUtils.markdownToHtmlExtensions(article.getDescription()));
        }
        model.addAttribute("articles", articles);
        return "article";
    }

}
