package com.example.ff.controller;

import com.example.ff.entity.MyTest;
import com.example.ff.utils.HttpUtils;
import com.example.ff.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;

@RestController
@CrossOrigin(origins = "*")
public class Contorller {
    @Value("${aaa.url}")
    private String uuu ;

    @Value("${api.appcode}")
    String appcode ;

    @Autowired
    private MyTest  myTest ;

    @GetMapping("hello")
    public String hello(@RequestParam (value = "message", defaultValue = "hello") String message){
        String host = "https://gyytz.market.alicloudapi.com";
        String path = "/sms/smsSend";
        String method = "POST";

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "mobile");
        querys.put("param", "**code**:12345,**minute**:1");

//smsSignId（短信前缀）和templateId（短信模板），可登录国阳云控制台自助申请。参考文档：http://help.guoyangyun.com/Problem/Qm.html

        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "908e94ccf08b4476ba6c876d13f084ad");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从\r\n\t    \t* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java\r\n\t    \t* 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "agd" ;
    }
    @PostMapping("/a")
    @GetMapping("/a")
    public String a(@RequestParam(defaultValue = "10") String number){
        return RandomNumber.randomNumber(Integer.parseInt(number))  ;
    }
}
