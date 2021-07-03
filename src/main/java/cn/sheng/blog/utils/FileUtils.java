package cn.sheng.blog.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传工具类
 */
public class FileUtils {

    //System.getProperty("user.dir")  返回的是当前工程的目录
    private static final String prePath = System.getProperty("user.dir") + "/src/main/resources/static/upload/";

    /**
     * 上传文件
     * @param file
     * @return 返回文件路径（以相对路径放回）
     */
    public static String uploadFile(MultipartFile file, String editPicturePath, int type) {
        if(file.isEmpty()) {
            return "路径为空";
        }
        // 获取原文件名
        String originFileName = file.getOriginalFilename();
        // 我们通过UUID 来重新重组文件名
        String uid = UUID.randomUUID().toString();
        assert originFileName != null;
        String suffix = originFileName.substring(originFileName.lastIndexOf('.') + 1);
        String path = editPicturePath + uid + "." + suffix;
        String returnPath;
        if (type == 1) {
            returnPath = "/upload/" + uid + "." + suffix;
        } else if (type == 2) {
            returnPath = uid + "." + suffix;
        } else {
            returnPath = null;
        }

        File newFile = new File(path);
        if(newFile.getParentFile() != null && !newFile.getParentFile().exists()) {
            System.out.println("创建目录ing");
            // 上面的 newFile.getParentFile() 已经保证了不为null.
            if(newFile.getParentFile().mkdirs()) {
                System.out.println("创建目录成功");
            }else {
                System.out.println("创建目录失败");
                return "";
            }
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return returnPath;
    }

    /**
     * 上传文件
     * @param file
     * @return 返回文件路径（以相对路径放回）
     */
   /* public static String uploadFile(MultipartFile file) {
        if(file.isEmpty()) {
            return "路径为空";
        }
        // 获取原文件名
        String originFileName = file.getOriginalFilename();
        // 我们通过UUID 来重新重组文件名
        String uid = UUID.randomUUID().toString();
        assert originFileName != null;
        String suffix = originFileName.substring(originFileName.lastIndexOf('.') + 1);
        String path = prePath + uid + "." + suffix;
        String returnPath = "/upload/" + uid + "." + suffix;
        File newFile = new File(path);
        if(newFile.getParentFile() != null && !newFile.getParentFile().exists()) {
            System.out.println("创建目录ing");
            // 上面的 newFile.getParentFile() 已经保证了不为null.
            if(newFile.getParentFile().mkdirs()) {
                System.out.println("创建目录成功");
            }else {
                System.out.println("创建目录失败");
                return "";
            }
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return returnPath;
    }*/

}
