package com.javatechie.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OpenAIChatService {

    private final ChatClient chatClient;

    public OpenAIChatService(@Qualifier("openAIChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chatWithOpenAILLM(String message) {
        return chatClient
                .prompt(message)
                .call()
                .content();
    }
}
