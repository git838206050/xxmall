package cn.lcy.xxmall.util;

import cn.lcy.xxmall.constants.GlobalConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 操作文件工具类
 * @Author LCY
 * @Date 2017/11/5 20:32
 */
@Component
public class FileUtilByLcy {
    /**
     * 上传单个图片
     * @param file 使用springMVC 上传文件的MultipartFile类 接收前台的file文件对象
     * @param fileSize 文件大小。单位为b。1k:1024  、 500k:512000 、 600k:614400 、 700k:716800 、 800k:819200 、 1m:1048576
     * @param fileType 图片后缀名。目前支持 jpg、png。多个直接保存至数组传进来。
     * @param fileCatalog 文件目录：如传入： admin\header\。 注意：这是相对路径，开头目录请在GlobalConstants类配置。
     * @param isValidate 是否为验证模式 Boolean类型
     * @param fileUrlType 文件路径类型。0：后台，1前台
     * @return 0：上传失败，未知错误；1（验证模式）:上传成功; 返回文件相对路径（非验证模式）：上传成功； -1:文件为空； -2：文件过大； -3：文件类型不一致； -4：文件是jpg后缀，但是错误、不能显示的图片；
     */
        public static String uploadImageFile(MultipartFile file,Long fileSize,String[] fileType,String fileCatalog,Boolean isValidate,byte fileUrlType){
        String filePath = "";
        if(fileUrlType == 0){
            filePath = GlobalConstants.bgFileUploadUrl+fileCatalog;  // 文件路径
        }else if(fileUrlType == 1){
            filePath = GlobalConstants.fdFileUploadUrl+fileCatalog;  // 文件路径
        }
        String fileName = null;
        // 返回上传状态。
        String result = "0";
        // 判断文件是否不为空
        if(file != null && !file.isEmpty()){
            try {
                // 把文件后缀替换成MultipartFile的getContentType输出的类型
                for(int i=0; i<fileType.length; i++){
                    if(fileType[i].equals("jpg") && file.getContentType().equals("image/jpeg")){
                        result = "1";
                        fileName = Md5Util.md5(StrUtil.newString(file.getBytes()))+".jpg";
                        filePath += fileName;
                    }else if(fileType[i].equals("png") && file.getContentType().equals("image/png")){
                        result = "1";
                        fileName = Md5Util.md5(StrUtil.newString(file.getBytes()))+".png";
                        filePath += fileName;
                    }
                }

                // 如果文件大于500k
                if(file.getSize() > fileSize){
                    result = "-2";
                }

                // 如果文件是jpg后缀，但是错误、不能显示的图片；
                BufferedImage bi = ImageIO.read(file.getInputStream());
                if (bi == null) {
                    result = "-4";
                }else if(result.equals("1")){
                    if(!isValidate) {
                        // 上传图片
                        file.transferTo(new File(filePath));
                        result = fileCatalog+fileName;
                    }else{
                        result = "1";
                    }
                }
            }catch (IOException ioE){
                result = "0";
                ioE.printStackTrace();
            }
        }else{
            // 文件为空
            result = "-1";
        }

        return result;
    }
}
