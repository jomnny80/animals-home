package com.puppy.animals.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/pic1")
    public String hello(){
        return "hello";
    }
}
