package cn.lcy.xxmall.test.util;

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
        String skuValue = "[{\"0\":\"123\",\"1\":\"123\",\"2\":\"123\"},{\"0\":\"123\",\"1\":\"123\",\"2\":\"123\"},{\"0\":\"abc\",\"1\":\"2_1_img\",\"2\":\"2_2_img\",\"3\":\"2_3_img\",\"4\":\"2_4_img\"},{}]";
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
//            System.out.println(linkedTreeMap.keySet());
        }
        System.out.println("s");
    }
}
