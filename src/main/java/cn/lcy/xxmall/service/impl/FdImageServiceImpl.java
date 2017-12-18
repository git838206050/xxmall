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
            String fileName = Md5Util.md5(StrUtil.newString(file.getBytes()));
            // 图片密文
            String fileCiphertext = Md5Util.md5(StrUtil.newString(file.getBytes()));

            // 查看数据库内是否存在相同的该图片加密
            FdImageExample fdImageExample = new FdImageExample();
            FdImageExample.Criteria criteria = fdImageExample.or();
            criteria.andImageencrypeEqualTo(fileCiphertext);
            fdImage = fdImageMapper.selectByExample(fdImageExample).size()<=0 ? null:fdImageMapper.selectByExample(fdImageExample).get(0);

            if(fdImage == null){
                fdImage = new FdImage();
                fdImage.setImageurl("images\\"+fileName);
                fdImage.setImageencrype(fileCiphertext);
                fdImage.setUsenum(1);
                fdImageMapper.insert(fdImage);
                state = fdImage.getId();
                fdImage = null;
            }else{
                state = fdImage.getId();
            }

        }catch (Exception e){
            e.printStackTrace();
            state = 0;
        }finally {
            return state;
        }

    }

    @Override
    public List<FdImage> getFdImages() {
        FdImageExample fdImageExample = new FdImageExample();
        FdImageExample.Criteria criteria = fdImageExample.or();
        criteria.andIdIsNotNull();
        return fdImageMapper.selectByExample(fdImageExample);
    }

    @Override
    public FdImage getFdImageByImageEncrypt(String imageEncrypt) {
        FdImageExample fdImageExample = new FdImageExample();
        FdImageExample.Criteria criteria = fdImageExample.or();
        criteria.andImageencrypeEqualTo(imageEncrypt);
        List<FdImage> fdImageList = fdImageMapper.selectByExample(fdImageExample);
        FdImage fdImage = null;
        if(fdImageList.size() != 0){
            fdImage = fdImageList.get(0);
        }
        return fdImage;
    }
}
