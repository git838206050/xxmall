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
     * 更新广告到期时间
     * @param targetId 广告对象id
     * @param expiretime 到期时间
     * @return
     */
    int updateAdvertisementOfExpiretime(int targetId, String expiretime);

    /**
     * 根据标识修改指定广告
     * @param targetId 对象ID
     * @param width 广告图片宽度
     * @return 0表示失败
     */
    int updateAdvertisementOfWidth(int targetId, String width);

    /**
     * 根据标识修改指定广告
     * @param targetId 对象ID
     * @param height 广告图片高度
     * @return 0表示失败
     */
    int updateAdvertisementOfHeight(int targetId, String height);

    /**
     * 根据标识修改指定广告
     * @param targetId 对象ID
     * @param showurlposition 显示位置
     * @return 0表示失败
     */
    int updateAdvertisementOfShowurlposition(int targetId, String showurlposition);

    /**
     * 根据标识修改指定广告
     * @param targetId 对象ID
     * @param isfixedshow 是否固定显示
     * @return 0表示失败
     */
    int updateAdvertisementOfIsfixedshow(int targetId, String isfixedshow);

    /**
     * 根据标识修改指定广告
     * @param targetId 对象ID
     * @param advertname 广告名称
     * @return 0表示失败
     */
    int updateAdvertisementOfAdvertname(int targetId, String advertname);

    /**
     * 根据标识执行广告到期操作
     * @param id 广告ID
     * @return
     */
    int expireAdvertisementById(int id);
}
