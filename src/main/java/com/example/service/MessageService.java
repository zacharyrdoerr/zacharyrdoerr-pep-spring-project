package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.MessageRepository;
import java.util.List;
import com.example.entity.Message;
import java.util.Optional;

@Service
@Transactional
public class MessageService {

    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    // service method to post a message
    public Message postMessage(Message message){

        return messageRepository.save(message);
    }
    // service method to return all messages
    public List<Message> getAllMessages(){

        return messageRepository.findAll();
    }

    // service method to return a message by id
    public Message getMessage(int id){

        Optional<Message> optionalMessage = messageRepository.findById(id);

        if (optionalMessage.isPresent()){
            return optionalMessage.get();
        }else{
            return null;
        }
        
    }
    
    // service method to delete a message by id and return the amount of rows affected
    public int deleteMessage(int id){

        return messageRepository.deleteMessageById(id);
    } 

    // service method to update a message by id and return the amount of rows affected
    public int updateMessage(int id, String newMessageText){

        if (!(newMessageText.isBlank()) && newMessageText.length() < 256){

            return messageRepository.updateMessageById(id, newMessageText);
        }else{
            return 0;
        }
    }
}
