package com.care.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/")
    public String chat(Model model) {
        model.addAttribute("messages", chatService.getAllMessages());
        return "chat"; // chat.jsp로 이동
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String username, @RequestParam String content) {
        Message message = new Message();
        message.setUsername(username);
        message.setContent(content);
        chatService.saveMessage(message);
        return "redirect:/"; // 메시지 전송 후 메인 페이지로 리다이렉트
    }
}
