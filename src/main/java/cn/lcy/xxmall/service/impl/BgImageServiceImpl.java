package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.BgImageMapper;
import cn.lcy.xxmall.pojo.BgImage;
import cn.lcy.xxmall.pojo.BgImageExample;
import cn.lcy.xxmall.service.BgImageService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.Md5Util;
import cn.lcy.xxmall.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 后台图片DAO
 * @Author LCY
 * @Date 2017/11/7 10:29
 */
public class BgImageServiceImpl implements BgImageService {
    @Autowired
    private BgImageMapper bgImageMapper;


    @Override
    public int insertImage(MultipartFile file) {
        BgImage bgImage = new BgImage();
        int state = 0;
        try {
            String fileName = Md5Util.md5(DateUtil.convertDateToString(DateUtil.getDate(), 1));
            // 图片密文
            String fileCiphertext = Md5Util.md5(StrUtil.newString(file.getBytes()));
            bgImage.setImageurl(fileName);
            bgImage.setImageencrypt(fileCiphertext);
            bgImage.setUsenum(1);
        }catch (Exception e){
            e.printStackTrace();
            bgImage = null;
        }

        if(bgImage != null){
            state = bgImageMapper.insert(bgImage);
        }
        return state;
    }

    @Override
    public List<BgImage> getBgImages() {
        BgImageExample bgImageExample = new BgImageExample();
        BgImageExample.Criteria criteria = bgImageExample.or();
        criteria.andIdNotEqualTo(-1);
        return bgImageMapper.selectByExample(bgImageExample);
    }

    @Override
    public BgImage getBgImageByImageEncrypt(String imageEncrypt) {
        BgImageExample bgImageExample = new BgImageExample();
        BgImageExample.Criteria criteria = bgImageExample.or();
        criteria.andImageencryptEqualTo(imageEncrypt);
        BgImage bgImage = bgImageMapper.selectByExample(bgImageExample).get(0);
        return bgImage;
    }

    @Override
    public List<BgImage> getBgImageByUseNum(int useNum) {
        BgImageExample bgImageExample = new BgImageExample();
        BgImageExample.Criteria criteria = bgImageExample.or();
        criteria.andUsenumEqualTo(useNum);
        return bgImageMapper.selectByExample(bgImageExample);
    }
}
