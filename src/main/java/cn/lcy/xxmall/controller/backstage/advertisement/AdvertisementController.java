package cn.lcy.xxmall.controller.backstage.advertisement;

import cn.lcy.xxmall.constants.GlobalConstants;
import cn.lcy.xxmall.pojo.Advertisement;
import cn.lcy.xxmall.pojo.common.JsonLayui;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.AdvertisementService;
import cn.lcy.xxmall.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 广告
 * @Author LCY
 * @Date 2017/12/19 9:12
 */
@Controller
@RequestMapping(value = "/xxmall/backstage/advertisementManage")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    /**
     * 分页显示所有广告
     * @param page 页码数
     * @param limit 每页显示数
     * @return
     */
    @RequestMapping(value = "/showAdvertisements")
    @ResponseBody
    public JsonLayui showAdvertisements(@RequestParam(value = "page" , required = false) Integer page,
                                        @RequestParam(value = "limit" , required = false) Integer limit){
        // 默认显示第一页
        if(page == null || page < 1){
            page = 1;
        }
        // 默认每页显示5条
        if(limit == null || limit < 1){
            limit = 5;
        }
        JsonLayui jsonLayui = new JsonLayui();
        // 分页
        PageHelper.startPage(page,limit);
        List<Advertisement> advertisementList = advertisementService.getAdvertisements();
        PageInfo pageInfo = new PageInfo(advertisementList);
        if(advertisementList.size() > 0){
            jsonLayui.setCode(0);
            // 获取数据的总数
            jsonLayui.setCount( pageInfo.getTotal() );
            jsonLayui.setMsg(GlobalConstants.operaction_success_message);
            jsonLayui.setData(jsonLayui.toObject(advertisementList));
        }
        jsonLayui.setLimit(Long.valueOf(limit));
        jsonLayui.setPage(Long.valueOf(page));
        return jsonLayui;
    }

    /**
     * 执行添加广告操作
     * @param advertisement
     * @param advertisementImage
     * @return
     */
    @RequestMapping(value = "/insertAdvertisements")
    @ResponseBody
    public JsonResult insertAdvertisements(Advertisement advertisement, @RequestParam(value = "advertimage" , required = true)MultipartFile advertisementImage,
                                           @RequestParam(value = "owidth" , required = false)String owidth,
                                           @RequestParam(value = "oheight" , required = false)String oheight,
                                           @RequestParam(value = "oisfixedshow" , required = false)String oisfixedshow,
                                           @RequestParam(value = "oexpiretime" , required = false)String oexpiretime
                                           ){
        JsonResult jsonResult = new JsonResult();
        try {
            advertisement.setWidth(Double.valueOf(owidth));
            advertisement.setHeight(Double.valueOf(oheight));
            advertisement.setIsfixedshow(Byte.valueOf(oisfixedshow));
            advertisement.setExpiretime(DateUtil.getDate(oexpiretime,0));
            if( advertisementService.insertAdvertisement(advertisement, advertisementImage) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    /**
     * 执行广告到期操作
     * @param advertisementId
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonResult expireAdvertisements(@RequestParam(value = "advertisementId" , required = true)Integer advertisementId){
        JsonResult jsonResult = new JsonResult();
        try {
            if(advertisementService.expireAdvertisementById(advertisementId) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
                jsonResult.setMessage(GlobalConstants.operaction_failed_message);
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    /**
     * 更新广告到期时间
     * @param targetId 广告id
     * @param expiretime 广告到期时间
     * @return
     */
    @PostMapping(value = "/updateExpiretime")
    @ResponseBody
    public JsonResult updateExpiretime(@RequestParam(value = "targetId" , required = true)Integer targetId,
                                       @RequestParam(value = "expiretime" , required = true)String expiretime){
        JsonResult jsonResult = new JsonResult();
        try {
            if(advertisementService.updateAdvertisementOfExpiretime(targetId,expiretime) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                throw new NullPointerException();
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "/updateAdvertisementOfWidth")
    @ResponseBody
    public JsonResult updateAdvertisementOfWidth(@RequestParam(value = "targetId" , required = true)Integer targetId,
                                                @RequestParam(value = "width" , required = true)String width){
        JsonResult jsonResult = new JsonResult();
        try {
            if(advertisementService.updateAdvertisementOfWidth(targetId,width) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                throw new NullPointerException();
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "/updateAdvertisementOfHeight")
    @ResponseBody
    public JsonResult updateAdvertisementOfHeight(@RequestParam(value = "targetId" , required = true)Integer targetId,
                                                    @RequestParam(value = "height" , required = true)String height){
        JsonResult jsonResult = new JsonResult();
        try {
            if(advertisementService.updateAdvertisementOfHeight(targetId,height) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                throw new NullPointerException();
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "/updateAdvertisementOfShowurlposition")
    @ResponseBody
    public JsonResult updateAdvertisementOfShowurlposition(@RequestParam(value = "targetId" , required = true)Integer targetId,
                                                            @RequestParam(value = "showurlposition" , required = true)String showurlposition){
        JsonResult jsonResult = new JsonResult();
        try {
            if(advertisementService.updateAdvertisementOfShowurlposition(targetId,showurlposition) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                throw new NullPointerException();
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "/updateAdvertisementOfIsfixedshow")
    @ResponseBody
    public JsonResult updateAdvertisementOfIsfixedshow(@RequestParam(value = "targetId" , required = true)Integer targetId,
                                                       @RequestParam(value = "isfixedshow" , required = true)String isfixedshow){
        JsonResult jsonResult = new JsonResult();
        try {
            if(advertisementService.updateAdvertisementOfIsfixedshow(targetId,isfixedshow) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                throw new NullPointerException();
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

    @PostMapping(value = "/updateAdvertisementOfAdvertname")
    @ResponseBody
    public JsonResult updateAdvertisementOfAdvertname(@RequestParam(value = "targetId" , required = true)Integer targetId,
                                                       @RequestParam(value = "advertname" , required = true)String advertname){
        JsonResult jsonResult = new JsonResult();
        try {
            if(advertisementService.updateAdvertisementOfAdvertname(targetId,advertname) != 0){
                jsonResult.setErrorCode(GlobalConstants.operaction_success_code);
                jsonResult.setMessage(GlobalConstants.operaction_success_message);
            }else{
                throw new NullPointerException();
            }
        }catch (Exception e){
            jsonResult.setErrorCode(GlobalConstants.operaction_failed_code);
            jsonResult.setMessage(GlobalConstants.operaction_failed_message);
        }
        return jsonResult;
    }

}
