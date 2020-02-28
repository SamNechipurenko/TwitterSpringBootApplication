package com.twitter.controller;


import com.twitter.enteties.Comment;
import com.twitter.enteties.Message;
import com.twitter.service.CommentService;
import com.twitter.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller // RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private CommentService cs;

    @GetMapping("/")
    public String hello(Model mav){
       List<Message> messagesList = messageService.findAll();
        mav.addAttribute("messageList", messagesList);
        return "index";
    }

    @GetMapping("/lookAtMessage")
    public String lookAtMessage(Model mav, @RequestParam("messageId") int id){
        Message message = messageService.findMessageById(Long.valueOf(id)).get();
        mav.addAttribute("message", message);

       for(Comment c : message.getCommentsCollection() ){
            System.out.println(c.getComment());
        }

        System.out.println(message.getMessage());
        return "message";
    }

    @PostMapping("/sendMessage")
    public void sendMsq(@RequestParam("message") String message, HttpServletResponse response) throws IOException {
        messageService.sendMessage(message);
        System.out.println(message);
        response.sendRedirect("/");
    }



//

}
