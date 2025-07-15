package com.example.entity;



/*
 * New class to represent a message update request
 * Allows controller to use Jackson Update mapper to parse the updated message text from json body
 */

public class UpdateRequest {
    
    String messageText;

    // Default no args constructor
    public UpdateRequest(){}

    // Constructor including given string
    public UpdateRequest(String str){

        this.messageText = str;
    }

    // getter/setter methods
    public String getMessageText(){

        return this.messageText;
    }

    public void setMessageText(String str){

        this.messageText = str;
    }
}
