package com.njxz.xtyblog.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ShareWordController {

    @MessageMapping("/shareWord")
    @SendTo("/topic/getShareWord")
    public String shareWord(String content)
    {
        System.out.println(content);
        return content;
    }
}
