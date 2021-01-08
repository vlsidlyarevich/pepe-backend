package com.github.vlsidlyarevich.pepeserver.web.ws;

import com.github.vlsidlyarevich.pepeserver.web.ws.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class TestController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return new Message("Hello " + message.getBody());
    }
}
