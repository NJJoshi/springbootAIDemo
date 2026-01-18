package com.javatechie.controller;

import com.javatechie.service.OllamaMultiModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/multimodelchat/api")
public class MultiModelChatController {

    private static final Logger log = LoggerFactory.getLogger(OpenAIChatController.class);

    @Autowired
    private OllamaMultiModelService ollamaMultiModelService;

    @GetMapping("/ollama/{model}/chat")
    public String chat(@RequestParam String message, @PathVariable String model) {
        log.info("Received request to chat with model {}", model);
        return  ollamaMultiModelService.getChatClient(model).prompt(message)
                .call()
                .content();
    }
}
