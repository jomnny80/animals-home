package com.puppy.animals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/hello-success")
    public String helloSuccess(Model model){
        //  model 中的數據會被放在請求域中 == request.setAttribute("a", aa);
        model.addAttribute("title", "Hi Title!");
        model.addAttribute("link", "https://www.youtube.com");
        return "success";
    }
}
