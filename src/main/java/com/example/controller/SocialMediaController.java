package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import com.example.service.AccountService;
import com.example.service.MessageService;
import com.example.entity.Account;
import com.example.entity.Message;



/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@Controller
@ResponseBody
//@RequestMapping() not necessary since all interactions occur from localhost:8080 which is default path
public class SocialMediaController {

    // declarations for service classes
    @Autowired
    public AccountService accountService;

    @Autowired
    public MessageService messageService;

    // post mapping for dealing with new user registrations
    @PostMapping("/register")
    public Account register(@RequestBody Account newAcc){
        return accountService.persistAccount(newAcc);
    }

    // post mapping for dealing with user login verification
    @PostMapping("/login")
    public Account login(@RequestBody Account userAcc){
        return accountService.getAccountByUsernameAndPassword(userAcc);
    }

    // post mapping for dealing with new messages
    @PostMapping("/messages")
    public Message postMessage(@RequestBody Message message){
        return messageService.postMessage(message);
    }

    // get mapping for retrieving all messages in db
    @GetMapping("/messages")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    // get mapping for retrieving a message specified by id
    @GetMapping("/messages/{messageId}")
    public Message getMessage(@PathVariable int messageId){
        return messageService.getMessage(messageId);
    }

    // delete mapping for deleting a message specified by id
    @DeleteMapping("/messages/{messageId}")
    public int deleteMessage(@PathVariable int messageId){
        return messageService.deleteMessage(messageId);
    }

    // patch mapping for updating a message specified by id
    @PatchMapping("/messages/{messageId}")
    public int updateMessage(@PathVariable int messageId, @RequestBody String newMessageText){
        return messageService.updateMessage(messageId, newMessageText);
    }

    // get mapping for retrieving all messages posted by a specified accountId
    @GetMapping("/accounts/{accountId}/messages")
    public List<Message> getMessagesByUser(@PathVariable int accountId){
        return messageService.getMessagesByPostedBy(accountId);
    }
    
}
