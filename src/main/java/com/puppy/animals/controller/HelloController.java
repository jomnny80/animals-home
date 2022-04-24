package com.puppy.animals.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class HelloController {

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping
    public String getUser(){
        return "Get user";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping
    public String saveUser(){
        return "Post user";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping
    public String putUser(){
        return "Put user";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping
    public String deleteUser(){
        return "Delete user";
    }

    // change _method to custom param
    // to see WebConfig hiddenHttpMethodFilter();
}
