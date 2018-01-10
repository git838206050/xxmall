package cn.lcy.xxmall.controller.frontdesk.index;

import cn.lcy.xxmall.pojo.ProductType;
import cn.lcy.xxmall.pojo.common.JsonResult;
import cn.lcy.xxmall.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 前端首页控制器
 */
@Controller
@RequestMapping(value = "/xxmall/frontdesk")
public class FrontdeskIndexController {
    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/showProductType")
    @ResponseBody
    public JsonResult showProductType(){
        JsonResult jsonResult = new JsonResult();
        Map<Object,Object> productTypeMap = new HashMap<Object, Object>();
        productTypeMap.put("productType",productTypeService.getProductTypeByOrderNum(0,4));

        jsonResult.setItem(productTypeMap);
        jsonResult.setMessage("连接成功！");
        jsonResult.setErrorCode("200");
        return jsonResult;
    }
}
