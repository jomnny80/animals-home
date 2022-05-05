package com.puppy.animals.controller;

import com.puppy.animals.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {

    @ResponseBody // RequestResponseBodyMethodProcessor ---> messageConverter
    @GetMapping("/file")
    public FileSystemResource file(){

        //文件以這樣的方式返回，看是誰處理的
        return null;
    }

    @ResponseBody // 利用返回值處理器裡面的消息轉換器進行處理
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(25);
        person.setBirth(new Date());
        person.setUserName("Test Response");

        return person;
    }
}
