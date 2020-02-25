package com.twitter.service;

import com.twitter.enteties.Message;
import com.twitter.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public void sendMessage(String message){
        Message newMessage = new Message();
        newMessage.setMessage(message);
        //newMessage.setDate(new Date());
        System.out.println(new Date());
        messageRepository.save(newMessage);
    }
}

