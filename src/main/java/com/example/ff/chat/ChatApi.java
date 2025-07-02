package com.example.ff.chat;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api") //定义请求路径（类或方法级别）
@RequiredArgsConstructor // 自动生成构造函数，用于依赖注入（需要配合final字段）
@RestController //声明为REST控制器，返回值自动转为json/xml
public class ChatApi {



    @GetMapping("/low/chat")
    public String lowChat(){
        ChatLanguageModel model = OpenAiChatModel.builder().baseUrl("").apiKey("").modelName("").build() ;

        return model.chat("你好")  ; 
    }
}
