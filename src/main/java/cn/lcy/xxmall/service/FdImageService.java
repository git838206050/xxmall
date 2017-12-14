package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.FdImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 前端图片业务类
 * @Author LCY
 * @Date 2017/12/10 20:32
 */
public interface FdImageService {
    /**
     * 添加指定图片
     * @param file
     * @return 图片表ID
     */
    int insertImage(MultipartFile file);

    /**
     * 获取所有图片
     * @return
     */
    List<FdImage> getBgImages();

    /**
     * 根据标识获取指定图片对象
     * @param imageEncrypt 图片加密后的密文
     * @return
     */
    FdImage getBgImageByImageEncrypt(String imageEncrypt);

}
