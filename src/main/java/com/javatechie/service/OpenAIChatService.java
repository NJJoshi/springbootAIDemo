package com.javatechie.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OpenAIChatService {

    private Map<String, ChatClient> chatClient;

    public OpenAIChatService(@Qualifier("openAIChatClient")  ChatClient defaultChatClient,
                                   @Qualifier("customGPTClient")  ChatClient gpt52ChatClient) {
        chatClient = new HashMap<>();
        chatClient.put("defaultGPTClient", defaultChatClient);
        chatClient.put("customGPTClient", gpt52ChatClient);
    }

    public String chatWithOpenAILLM(String message) {
        return chatClient
                .get("defaultGPTClient")
                .prompt(message)
                .call()
                .content();
    }

    public String chatWithSpecificModel(String model, String message) {
        return chatClient
                .get(model)
                .prompt(message)
                .call()
                .content();
    }
}
