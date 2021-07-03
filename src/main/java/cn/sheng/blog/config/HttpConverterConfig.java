package cn.sheng.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HttpConverterConfig implements WebMvcConfigurer {

    @Value("${file.upload.path}")
    private String localPath;

    @Value("${file.upload.editpicturePath}")
    private String editPath;

    //添加本地静态资源访问过滤
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        registry.addResourceHandler("/**")
//                .addResourceLocations("resources/", "static/", "public/",
//                        "META-INF/resources/")
//                .addResourceLocations("classpath:resources/", "classpath:static/",
//                        "classpath:public/", "classpath:META-INF/resources/");

        //其中image表示访问的前缀。"file:" +  localPath是文件存在本地的路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:" +  localPath);

        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + editPath);
//        registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/templates/admin/");
    }

}
