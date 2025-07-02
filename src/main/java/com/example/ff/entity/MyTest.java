package com.example.ff.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnClass(name = "com.example.ff.chat.C")
public class MyTest {
}
