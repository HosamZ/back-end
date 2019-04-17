package at.nacs.the_magic_8ball.controller;

import at.nacs.the_magic_8ball.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class EightBallMessageController {

    private final Manager manager;

    @ModelAttribute("message")
    Message message() {
        return manager.display();
    }

    @GetMapping
    String page() {
        return "messages/8ball-message";
    }
}
