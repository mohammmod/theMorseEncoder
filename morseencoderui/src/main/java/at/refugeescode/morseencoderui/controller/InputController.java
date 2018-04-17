package at.refugeescode.morseencoderui.controller;

import at.refugeescode.morseencoderui.model.Message;
import at.refugeescode.morseencoderui.service.SenderAndRicever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class InputController {


    @Autowired
    private SenderAndRicever senderAndRicever;
    private String sentence;
    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("morsecode",sentence);
        model.addAttribute("message",new Message());
        return "input";
    }

    @PostMapping
    public String showPage(Message message) {
        String sentences = senderAndRicever.getSentences(message);
        message.setText(sentences);
        this.sentence = sentences;
        return "redirect:/";
    }


}
