package com.example.ff.controller;



import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;


import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.TokenStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.concurrent.CompletableFuture;

@RestController
public class DeepSeek {
    interface Assistant {

        TokenStream chat(String message);
    }

    @Autowired
    @Qualifier("chat")
    private ChatModel model;
    @Autowired
    private StreamingChatModel streamingChatModel;

    @GetMapping("/model")
    public String hello(@RequestParam(value = "message", defaultValue = "hello") String message) {
        return model.chat(message);
    }

    @GetMapping("/steamModel")
    public void StreamWithMetadata(@RequestParam(value = "message", defaultValue = "hello") String message) {

        Assistant assistant = AiServices.create( Assistant.class, streamingChatModel );




        TokenStream tokenStream = assistant.chat("Tell me a joke");

        CompletableFuture<ChatResponse> futureResponse = new CompletableFuture<>();

        tokenStream.onPartialResponse(System.out::print)
                .onCompleteResponse(futureResponse::complete)
                .onError(futureResponse::completeExceptionally)
                .start();

        ChatResponse chatResponse = futureResponse.get(30, SECONDS);
        System.out.println("\n" + chatResponse);
    }
}

