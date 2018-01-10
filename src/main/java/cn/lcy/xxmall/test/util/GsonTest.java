package cn.lcy.xxmall.test.util;

import cn.lcy.xxmall.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author LCY
 * @Date 2017/12/5 16:36
 */
public class GsonTest {
    @Test
    public void testGson(){
        String skuValue = "[{\"0\":\"index\",\"1\":\"a1\",\"2\":\"a2\",\"3\":\"a3\"},{\"0\":\"b\",\"1\":\"b1\",\"2\":\"b2\"},{\"0\":\"图片\",\"1\":\"2_1_img\",\"2\":\"2_2_img\",\"3\":\"2_3_img\",\"4\":\"2_4_img\",\"5\":\"2_5_img\",\"6\":\"2_6_img\",\"7\":\"2_7_img\",\"8\":\"2_8_img\",\"9\":\"2_9_img\",\"10\":\"2_10_img\",\"11\":\"2_11_img\",\"12\":\"2_12_img\",\"13\":\"2_13_img\",\"14\":\"2_14_img\",\"15\":\"2_15_img\",\"16\":\"2_16_img\"},{}]";
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Object>>() {}.getType();
        ArrayList<Object> list = gson.fromJson(skuValue, type);
        LinkedTreeMap linkedTreeMap;
        for(int i=0; i<list.size(); i++){
            linkedTreeMap = (LinkedTreeMap)list.get(i);
            Set set = linkedTreeMap.keySet();
            for (Object str : set) {
                System.out.print(str+"|:");
                System.out.println(linkedTreeMap.get(str));
            }
        }

//        test3();
    }

    public void test2(){
//        String propertyvaluegroup = "[{\"0\":\"index\",\"1\":\"a1\",\"2\":\"a2\",\"3\":\"a3\"},{\"0\":\"b\",\"1\":\"b1\",\"2\":\"b2\"},{\"0\":\"图片\",\"1\":\"2_1_img\",\"2\":\"2_2_img\",\"3\":\"2_3_img\",\"4\":\"2_4_img\",\"5\":\"2_5_img\",\"6\":\"2_6_img\",\"7\":\"2_7_img\",\"8\":\"2_8_img\",\"9\":\"2_9_img\",\"10\":\"2_10_img\",\"11\":\"2_11_img\",\"12\":\"2_12_img\",\"13\":\"2_13_img\",\"14\":\"2_14_img\",\"15\":\"2_15_img\",\"16\":\"2_16_img\"},{}]";
//        boolean[] imageNum = {false, false, true, false};
//        List<String> productSKUImageFileName = new ArrayList<String>();
//
//        for(int i=1; i<=17; i++){
//            productSKUImageFileName.add(String.valueOf(i+"大图片"));
//        }
//
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<Object>>() {}.getType();
//        propertyvaluegroup = StrUtil.dislodgeAllTag(propertyvaluegroup);
//        ArrayList<Object> list = gson.fromJson(propertyvaluegroup, type);
//        LinkedTreeMap linkedTreeMap;
//        for(int i=0,k=0; i<list.size(); i++){
//            if(imageNum[i]){
//                linkedTreeMap = (LinkedTreeMap)list.get(i);
//                Set set = linkedTreeMap.keySet();
//                int j = 1;
//                for (Object str : set) {
//                    propertyvaluegroup = propertyvaluegroup.replace(String.valueOf(i+"_"+j+"_img"),productSKUImageFileName.get(k));
//                    k++;
//                    j++;
//                }
//            }
//        }


//        System.out.println(propertyvaluegroup);
    }

    public void test3(){
//        for(int i=0; i<1000000; i++){
//            if(i%3 != 0){
//                System.out.println(2/(i%3));
//            }else{
//                System.out.println(i);
//            }
//        }


//        for(int i=0; i<1000000; i++){
//            try{
//                System.out.println(2/(i%3));
//            }catch (Exception e){
//                System.out.println(i);
//            }
//        }
    }
}
