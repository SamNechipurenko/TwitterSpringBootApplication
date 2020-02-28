package com.twitter.service;

import com.twitter.enteties.Comment;
import com.twitter.enteties.Message;
import com.twitter.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        messageRepository.save(newMessage);
    }

    public Optional<Message> findMessageById(Long id){
        return messageRepository.findById(id);
    }

    public void sendComment(String comment, Long id){
        Message message = messageRepository.findById(id).get();

        Comment newComment = new Comment();
        newComment.setMessageId(message);
        newComment.setComment(comment);

        message.getCommentsCollection().add(newComment);
        messageRepository.save(message);
    }
}

