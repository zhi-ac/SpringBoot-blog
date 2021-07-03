package cn.sheng.blog.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
//
//@Configuration
//public class MyMultipartConfigElement {
//
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation("/pttms/tmp");//指定临时文件路径，这个路径可以随便写
//        return factory.createMultipartConfig();
//    }
//
//}
