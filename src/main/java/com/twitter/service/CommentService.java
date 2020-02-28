package com.twitter.service;

import com.twitter.enteties.Comment;
import com.twitter.enteties.Message;
import com.twitter.repositories.CommentRepository;
import com.twitter.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void sendComment(String comment, Message message){
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setMessageId(message);
        commentRepository.save(newComment);
    }
}
