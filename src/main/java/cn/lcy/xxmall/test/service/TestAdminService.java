package cn.lcy.xxmall.test.service;

import cn.lcy.xxmall.pojo.Admin;
import cn.lcy.xxmall.service.AdminService;
import cn.lcy.xxmall.test.base.SpringJunitTest;
import cn.lcy.xxmall.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TestAdminService extends SpringJunitTest{
    @Autowired
    private AdminService adminService;

    @Test
    public void testAdminService(){
        List<Admin> adminList = adminService.getAdmins();
        for(int i=0;i<adminList.size();i++) {
            System.out.println(adminList.get(i).getAdminname());
        }
        adminService.updataAdminOfprohibitLoginTime(4,10, DateUtil.getDate());


        // 读取文件
//        String fileName = "G:/test2.json";
//        File file = new File(fileName);
//        BufferedReader reader = null;
//        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
//            reader = new BufferedReader(new FileReader(file));
//            String tempString = null;
//            int line = 1;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
//            }
//            System.out.println("读取结束");
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }

        // 创建文件夹
//        String u=Class.class.getClass().getResource("/").getPath();
//        System.out.println(u);
//        File file = new File("G:\\data\\idea\\xxmall\\target\\xxmall\\backstage\\admin\\header");
//        file.mkdirs();
//
//        file = new File("D:\\A\\B\\D");
//        file.mkdir();
    }
}
