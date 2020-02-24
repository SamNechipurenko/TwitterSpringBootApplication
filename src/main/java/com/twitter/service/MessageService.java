package com.twitter.service;

import com.twitter.enteties.Message;
import com.twitter.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> findAll(){
        return messageRepository.findAll();
    }
}

