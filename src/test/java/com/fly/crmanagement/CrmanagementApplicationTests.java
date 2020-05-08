package com.fly.crmanagement;

import com.fly.crmanagement.util.QRCodeUtil;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class CrmanagementApplicationTests {

    public static void main(String[] args) {
        String text = "www.baidu.com";
        // 嵌入二维码的图片路径
        String imgPath = "C:\\Users\\FLY\\Music\\logo.jpeg";
        // 生成的二维码的路径及名称
        String destPath = "C:\\Users\\FLY\\Music\\qr.png";
        //生成二维码
        destPath = "C:\\Users\\FLY\\Music\\qrlink.png";
        try {
            QRCodeUtil.encode(text, imgPath, destPath, true);
            // 解析二维码
            String str = QRCodeUtil.decode(destPath);
            // 打印出解析出的内容
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
