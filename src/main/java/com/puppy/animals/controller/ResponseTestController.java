package com.puppy.animals.controller;

import com.puppy.animals.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(25);
        person.setBirth(new Date());
        person.setUserName("Test Response");

        return person;
    }
}
