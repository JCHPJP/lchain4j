package com.example.ff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class Contorller {
    @Value("${aaa.url}")
    private String uuu ;

    @GetMapping("hello")
    public String hello(){
        HashMap<String, Integer> mp = new HashMap<>() ;
        mp.put("12345",123456878) ;
//        System.out.println("dataSourse" + dataSource);
        System.out.println(uuu);
        return uuu;
    }

}
