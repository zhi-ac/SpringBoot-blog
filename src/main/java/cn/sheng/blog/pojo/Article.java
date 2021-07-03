package cn.sheng.blog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private int id;

    private String title;

    private String author;

    private String content;

    private String description;

    private String picture;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date date;

}
