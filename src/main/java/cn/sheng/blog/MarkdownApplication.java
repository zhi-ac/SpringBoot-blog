package cn.sheng.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
//排除原有的Multipart配置
//@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
@SpringBootApplication
public class MarkdownApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkdownApplication.class, args);
    }

//
//    /**
//     * 文件上传配置
//     * @return
//     */
//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //2.该处就是指定的路径(需要提前创建好目录，否则上传时会抛出异常)
//        factory.setLocation("/data/uploadtmp");
//        return factory.createMultipartConfig();
//    }
}
