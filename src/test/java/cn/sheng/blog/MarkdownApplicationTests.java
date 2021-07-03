package cn.sheng.blog;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.Date;

@SpringBootTest
class MarkdownApplicationTests {

    @Test
    void contextLoads() throws FileNotFoundException {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
    }

    @Test
    public void test01() {
            // TODO Auto-generated method stub
//            System.out.println(System.getProperty("user.dir"));

        TestDate testDate = new TestDate();
        testDate.setDate(new Date());
        System.out.println(testDate.getDate());
        System.out.println();

    }

}
//Tue Jun 29 20:21:14 CST 2021
//Tue Jun 29 20:21:59 CST 2021
@Data
class TestDate {
    private Date date;


}