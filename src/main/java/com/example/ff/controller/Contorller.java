package com.example.ff.controller;

import com.example.ff.entity.MyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class Contorller {
    @Value("${aaa.url}")
    private String uuu ;

    @Autowired
    private MyTest  myTest ;

    @GetMapping("hello")
    public HashMap<String, Integer> hello(){
        HashMap<String, Integer> mp = new HashMap<>() ;
        mp.put("12345",123456878) ;
//        System.out.println("dataSourse" + dataSource);
//        System.out.println(uuu);
        return mp;
    }

}
