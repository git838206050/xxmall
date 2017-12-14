package cn.lcy.xxmall.test.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.*;

/**
 * 爬取数据
 * @Author LCY
 * @Date 2017/11/23 20:14
 */
public class htmlPaCong {
    @Test
    public void testHtmlPC() throws IOException {
        File f = new File("G:\\pacong\\book2\\list&page=1(1).html");
        InputStream in = new FileInputStream(f);
        //读取数据，并将读取的数据存储到数组中
        byte[] b = new byte[(int) f.length()];//数据存储的数组
        int len = 0;
        int temp = 0;
        while((temp = in.read()) != -1){//循环读取数据，未到达流的末尾
            b[len] = (byte) temp;//将有效数据存储在数组中
            len ++;
        }
        String html = new String(b, 0, len, "UTF-8");
        Document doc = Jsoup.parse(html);
        String p_name = "";
        String p_img = "";
        String p_d = "";
        for(int i=0; i<doc.getElementsByClass("p-name").size(); i++){
            p_name = doc.getElementsByClass("p-name").eq(i).text();
            p_img = doc.select(".p-img img").eq(i).attr("src");
            if(p_img == null || p_img.equals("")){
                p_img = doc.select(".p-img img").eq(i).attr("data-lazy-img");
            }
            p_d = doc.select(".p-bookdetails").eq(i).text();
            System.out.println("名称："+p_name);
            System.out.println("图片："+p_img);
            System.out.println("简介："+p_d);
            System.out.println("========================"+i);
        }
    }
}
