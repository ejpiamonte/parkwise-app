package com.example.firebaseauth.model;

import com.google.firebase.Timestamp;

public class ChatModel {

    String message;
    String user_name;
    String messageID;
    String chat_image;
    Timestamp timestamp; // Change type to Timestamp

    public ChatModel() {
    }

    public ChatModel(String message, String user_name, String messageID, String chat_image, Timestamp timestamp) {
        this.message = message;
        this.user_name = user_name;
        this.messageID = messageID;
        this.chat_image = chat_image;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getChat_image() {
        return chat_image;
    }

    public void setChat_image(String chat_image) {
        this.chat_image = chat_image;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
