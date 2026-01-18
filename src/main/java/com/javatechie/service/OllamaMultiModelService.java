package com.javatechie.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OllamaMultiModelService {
    private Map<String, ChatClient> chatClient;
    public OllamaMultiModelService(@Qualifier("llama323bClient")  ChatClient ollama323bChatClient,
                                   @Qualifier("llama321bClient")  ChatClient ollama321bChatClient) {
            chatClient = new HashMap<>();
            chatClient.put("llama323bClient", ollama323bChatClient);
            chatClient.put("llama321bClient", ollama321bChatClient);
    }
    public ChatClient getChatClient(String name) {
        return chatClient.get(name);
    }
}
