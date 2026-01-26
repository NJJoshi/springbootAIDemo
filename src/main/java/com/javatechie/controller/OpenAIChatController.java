package com.javatechie.controller;

import com.javatechie.service.OllamaMultiModelService;
import com.javatechie.service.OpenAIChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/openai/api")
public class OpenAIChatController {


    private static final Logger log = LoggerFactory.getLogger(OpenAIChatController.class);
    private final OpenAIChatService openAIChatService;

    @Autowired
    private OllamaMultiModelService ollamaMultiModelService;

    public OpenAIChatController(OpenAIChatService openAIChatService) {
        this.openAIChatService = openAIChatService;
    }


    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return openAIChatService.chatWithOpenAILLM(message);
    }

    @GetMapping("/chat/{model}")
    public String chat(@RequestParam String message, @PathVariable String model) {
        log.info("Received request to chat with model {}", model);
        return  openAIChatService.chatWithSpecificModel(model,message);
    }
}
