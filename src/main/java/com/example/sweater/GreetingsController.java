package com.example.sweater;

import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingsController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String,Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping()
    public String main(Map<String,Object> model){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String,Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String,Object> model) {
        if (filter != null && filter != "") model.put("messages", messageRepo.findByTag(filter));
        else model.put("messages", messageRepo.findAll());

        return "main";
    }

    @PostMapping("deleteByTag")
    public String deleteFromDatabase(@RequestParam String deleteByTag, Map<String,Object> model) {
        if (deleteByTag != null && deleteByTag != "") {
            messageRepo.deleteByTag(deleteByTag);
            model.put("messages", messageRepo.findAll());
        }
        else model.put("messages", messageRepo.findAll());

        return "main";
    }

}
