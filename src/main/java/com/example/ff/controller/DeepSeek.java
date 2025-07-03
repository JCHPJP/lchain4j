package com.example.ff.controller;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class DeepSeek {

    @Autowired
    @Qualifier("chat")
    private ChatModel model;

    @Autowired
    private StreamingChatModel streamingChatModel;

    @GetMapping("/model")
    public String hello(@RequestParam(value = "message", defaultValue = "hello") String message) {
        return model.chat(message);
    }


    @GetMapping(value = "/stream" , produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> streamChat(@RequestParam String message) {
        return Flux.create(sink -> {
            streamingChatModel.chat(message, new StreamingChatResponseHandler() {
                @Override
                public void onPartialResponse(String s) {
                    sink.next(s);
                    System.out.print(s);
                }
                @Override
                public void onCompleteResponse(ChatResponse chatResponse) {
                    sink.complete();
                }

                @Override
                public void onError(Throwable throwable) {
                    sink.error(throwable);
                }
            });
        });
    }
}