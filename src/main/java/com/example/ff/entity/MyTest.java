package com.example.ff.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

@Component // 相当于一个Bean
@ConditionalOnBean(name="ffApplication")
public class MyTest {
}
