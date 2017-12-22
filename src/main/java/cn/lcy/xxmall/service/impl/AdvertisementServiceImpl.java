package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.AdvertisementMapper;
import cn.lcy.xxmall.pojo.Advertisement;
import cn.lcy.xxmall.pojo.AdvertisementExample;
import cn.lcy.xxmall.service.AdvertisementService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.FileUtilByLcy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 广告业务层
 * @Author LCY
 * @Date 2017/12/18 16:00
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementMapper advertisementMapper;

    @Override
    public int insertAdvertisement(Advertisement advertisement, MultipartFile advertisementImage) {
        Integer state = 0;
        // 添加图片
        String[] fileType = {"jpg","png"};
        String fileCatalog = "advertisement";
        String imageUrl = FileUtilByLcy.uploadImageFile( advertisementImage, 1048576L, fileType, fileCatalog, false, (byte)1);
        if(imageUrl.length() < 2){
            state = 0;
        }else{
            advertisement.setCreattime(DateUtil.getDate());
            state = DateUtil.compareTimeStamp(advertisement.getExpiretime(),advertisement.getCreattime());
        }
        if(state!=null && state==1){
            advertisement.setImageurl(imageUrl);
            state = advertisementMapper.insert(advertisement);
        }
        return state;
    }

    @Override
    public List<Advertisement> getAdvertisementByShowUrlPosition(String showUrlPosition) {
        AdvertisementExample advertisementExample = new AdvertisementExample();
        AdvertisementExample.Criteria criteria = advertisementExample.or();
        criteria.andShowurlpositionEqualTo(showUrlPosition);
        List<Advertisement> advertisementList = advertisementMapper.selectByExample(advertisementExample);
        return advertisementList;
    }

    @Override
    public List<Advertisement> getAdvertisementByShopId(int shopId) {
        AdvertisementExample advertisementExample = new AdvertisementExample();
        AdvertisementExample.Criteria criteria = advertisementExample.or();
        criteria.andShopidEqualTo(shopId);
        List<Advertisement> advertisementList = advertisementMapper.selectByExample(advertisementExample);
        return advertisementList;
    }

    @Override
    public List<Advertisement> getAdvertisements() {
        AdvertisementExample advertisementExample = new AdvertisementExample();
        AdvertisementExample.Criteria criteria = advertisementExample.or();
        criteria.andIdIsNotNull();
        List<Advertisement> advertisementList = advertisementMapper.selectByExample(advertisementExample);
        return advertisementList;
    }

    @Override
    public int updateAdvertisement(Advertisement advertisement) {
        Advertisement oAdvertisement = advertisementMapper.selectByPrimaryKey(advertisement.getId());
        if(oAdvertisement != null){
            advertisement.setShopid(oAdvertisement.getShopid());
            advertisement.setCreattime(oAdvertisement.getCreattime());
            advertisement.setExpiretime(oAdvertisement.getExpiretime());
        }
        return advertisementMapper.insert(advertisement);
    }

    @Override
    public int expireAdvertisementById(int id) {
        int state = 0;
        Advertisement advertisement = advertisementMapper.selectByPrimaryKey(id);
        if(advertisement != null){
            advertisement.setExpiretime(DateUtil.getDate());
            state = advertisementMapper.updateByPrimaryKey(advertisement);
        }
        return state;
    }
}
