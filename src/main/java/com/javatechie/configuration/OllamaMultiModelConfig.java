package com.javatechie.configuration;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaMultiModelConfig {

    @Value("${spring.ai.ollama.base-url}")
    private String baseUrl;

    @Bean
    public OllamaApi ollamaApi() {
        return new OllamaApi.Builder().baseUrl(baseUrl).build();
    }

    @Bean
    @Qualifier("llama323bClient")
    public ChatClient llama323bClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem("You are a helpful AI assistant powered by Llama2")
                .defaultOptions(ChatOptions.builder().model("llama3.2:3b").build())
                .build();
    }
    @Bean
    @Qualifier("llama321bClient")
    public ChatClient llama321bClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem("You are a helpful AI assistant powered by Llama2")
                .defaultOptions(ChatOptions.builder().model("llama3.2:1b").build())
                .build();
    }
}
