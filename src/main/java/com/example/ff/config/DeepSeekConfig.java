package com.example.ff.config;



import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class DeepSeekConfig {
    @Value("${api.url}")
    String url ;
    @Value("${api.api}")
    String api ;
    @Value("${api.model}")
    String modelName ;

    @Bean("chat")
    ChatModel chatModel(){
        return OpenAiChatModel.builder()
                .apiKey(api)
                .modelName(modelName)
                .baseUrl(url)
                .build() ;
    }
    @Bean
    StreamingChatModel chatModel1(){
        return OpenAiStreamingChatModel.builder()
                .apiKey(api)
                .modelName(modelName)
                .baseUrl(url)
                .build() ;
    }

}
