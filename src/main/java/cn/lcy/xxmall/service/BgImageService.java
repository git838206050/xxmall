package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.BgImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 后台图片管理
 * @Author LCY
 * @Date 2017/11/7 10:20
 */
public interface BgImageService {
    /**
     * 添加指定图片
     * @param file
     * @return
     */
    int insertImage(MultipartFile file);

    /**
     * 获取所有图片
     * @return
     */
    List<BgImage> getBgImages();

    /**
     * 根据标识获取指定图片对象
     * @param imageEncrypt 图片加密后的密文
     * @return
     */
    BgImage getBgImageByImageEncrypt(String imageEncrypt);

    /**
     * 根据标识获取指定图片对象
     * @param useNum 使用数量
     * @return
     */
    List<BgImage> getBgImageByUseNum(int useNum);
}
