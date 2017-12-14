package cn.lcy.xxmall.test.service;

import cn.lcy.xxmall.pojo.ProductType;
import cn.lcy.xxmall.service.ProductTypeService;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/27 23:09
 */
public class ProductTypeServiceTest extends SpringJunitTest {
    @Autowired
    private ProductTypeService productTypeService;

    @Test
    public void testShopService(){
        List<ProductType> productTypeList = productTypeService.getProductTypesByParent("0");
        for (int i = 0; i < productTypeList.size(); i++) {
//            System.out.print("\""+productTypeList.get(i).getProducttypename()+"\",");
        }

        List<ProductType> productTypeList2;
        List<ProductType> productTypeList3;
        System.out.print("[");
        for (int i = 0; i < productTypeList.size(); i++) {
            productTypeList2 = productTypeService.getProductTypesByParent(productTypeList.get(i).getSeed());
            System.out.print("[");
            for (int j = 0; j < productTypeList2.size(); j++) {
//                if(j!=productTypeList2.size()-1){
//                    System.out.print("\""+productTypeList2.get(j).getProducttypename()+"\",");
//                }else{
//                    System.out.print("\""+productTypeList2.get(j).getProducttypename()+"\"],");
//                }
                productTypeList3 = productTypeService.getProductTypesByParent(productTypeList2.get(j).getSeed());
                System.out.print("[");
                for (int k = 0; k < productTypeList3.size(); k++) {
                    if(k!=productTypeList3.size()-1){
                        System.out.print("[\""+productTypeList3.get(k).getProducttypename()+"\",\""+productTypeList3.get(k).getId()+"\"],");
                    }else{
                        if(j!=productTypeList2.size()-1){
                            System.out.print("[\""+productTypeList3.get(k).getProducttypename()+"\",\""+productTypeList3.get(k).getId()+"\"]],");
                        }else{
                            System.out.print("[\""+productTypeList3.get(k).getProducttypename()+"\",\""+productTypeList3.get(k).getId()+"\"]]");
                        }
                    }
                }
            }
            System.out.print("],");
        }
        System.out.print("]");
    }
}
