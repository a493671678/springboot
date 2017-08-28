package cn.lwq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String greeting(@RequestParam(required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "NewFile";
    }
    
}
