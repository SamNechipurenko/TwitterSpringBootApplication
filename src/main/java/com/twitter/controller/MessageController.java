package com.twitter.controller;


import com.twitter.enteties.Message;
import com.twitter.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller // RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String hello(Model mav){
       List<Message> messagesList = messageService.findAll();
        mav.addAttribute("messageList", messagesList);
        return "index";
    }

//

}
