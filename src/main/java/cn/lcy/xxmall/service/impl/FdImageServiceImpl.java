package cn.lcy.xxmall.service.impl;

import cn.lcy.xxmall.dao.FdImageMapper;
import cn.lcy.xxmall.pojo.FdImage;
import cn.lcy.xxmall.pojo.FdImageExample;
import cn.lcy.xxmall.service.FdImageService;
import cn.lcy.xxmall.util.DateUtil;
import cn.lcy.xxmall.util.Md5Util;
import cn.lcy.xxmall.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/12/10 20:34
 */
@Service
public class FdImageServiceImpl implements FdImageService {
    @Autowired
    private FdImageMapper fdImageMapper;

    @Override
    public int insertImage(MultipartFile file) {
        FdImage fdImage = null;
        int state = 0;
        try {
            String fileName = Md5Util.md5(DateUtil.convertDateToString(DateUtil.getDate(), 1));
            // 图片密文
            String fileCiphertext = Md5Util.md5(StrUtil.newString(file.getBytes()));

            // 查看数据库内是否存在相同的该图片加密
            FdImageExample fdImageExample = new FdImageExample();
            FdImageExample.Criteria criteria = fdImageExample.or();
            criteria.andImageencrypeEqualTo(fileCiphertext);
            fdImage = fdImageMapper.selectByExample(fdImageExample).get(0);

            if(fdImage == null){
                fdImage.setImageurl(fileName);
                fdImage.setImageencrype(fileCiphertext);
                fdImage.setUsenum(1);
                state = fdImageMapper.insert(fdImage);
            }else{
                state = fdImage.getId();
            }

        }catch (Exception e){
            e.printStackTrace();
            state = 0;
        }

        return state;
    }

    @Override
    public List<FdImage> getBgImages() {
        FdImageExample fdImageExample = new FdImageExample();
        FdImageExample.Criteria criteria = fdImageExample.or();
        criteria.andIdIsNotNull();
        return fdImageMapper.selectByExample(fdImageExample);
    }

    @Override
    public FdImage getBgImageByImageEncrypt(String imageEncrypt) {
        FdImageExample fdImageExample = new FdImageExample();
        FdImageExample.Criteria criteria = fdImageExample.or();
        criteria.andImageencrypeEqualTo(imageEncrypt);
        return fdImageMapper.selectByExample(fdImageExample).get(0);
    }
}
