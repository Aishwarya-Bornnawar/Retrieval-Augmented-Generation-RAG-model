package com.exaple.chatbot.controller;

import com.exaple.chatbot.service.EmbeddingService;
import com.exaple.chatbot.model.ChatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ChatbotController {

    @Autowired
    private EmbeddingService embeddingService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // Handle file upload
        embeddingService.processFile(file);
        return ResponseEntity.ok("File processed and embeddings stored.");
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatRequest chatRequest) {
        // Handle chat query
        String response = embeddingService.getChatResponse(chatRequest.getQuery());
        return ResponseEntity.ok(response);
    }
}
