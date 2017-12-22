package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.Advertisement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 广告业务类
 * @Author LCY
 * @Date 2017/12/18 15:32
 */
public interface AdvertisementService {
    /**
     * 执行添加广告功能
     * 对象内必须要的值：1、shopId，2、advertName，3、headerUrl，4、width，5、height，6、isFixedShow，7、showUrlPosition
     * @param advertisement
     * @return
     */
    int insertAdvertisement(Advertisement advertisement, MultipartFile advertisementImage);

    /**
     * 根据标识获取 广告对象
     * @param showUrlPosition 网页显示的路径
     * @return
     */
    List<Advertisement> getAdvertisementByShowUrlPosition(String showUrlPosition);

    /**
     * 根据标识获取指定广告
     * @param shopId
     * @return
     */
    List<Advertisement> getAdvertisementByShopId(int shopId);

    /**
     * 获取所有广告
     * @return
     */
    List<Advertisement> getAdvertisements();

    /**
     * 更新广告
     * @param advertisement 广告对象
     * @return
     */
    int updateAdvertisement(Advertisement advertisement);

    /**
     * 根据标识执行广告到期操作
     * @param id 广告ID
     * @return
     */
    int expireAdvertisementById(int id);
}
