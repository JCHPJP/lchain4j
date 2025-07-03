package com.example.ff.utils;

import java.util.Random;

public class RandomNumber {
    public static  String randomNumber(int time){
        Random random = new Random();
        StringBuilder strs = new StringBuilder();
        for(int i=0;i<time;i++){
            int anInt = random.nextInt(10);
            strs.append(anInt) ;
        }
        return strs.toString();
    }

}
