package com.example.service;

import org.springframework.stereotype.Service;

import com.example.repository.MessageRepository;

@Service
public class MessageService {

    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    
}
