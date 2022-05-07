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

    /**
     * 1. 瀏覽器請求直接返回 xml                        [application/xml] --> jacksonXmlConverter
     * 2. 如果是 ajax 請求，返回 json                   [application/json] --> jacksonJsonConverter
     * 3. 如果是 app 發請求，返回自定義協議數據            [application/xxx] --> xxxConverter
     *      屬性值1;屬性值2;
     *
     * Step:
     * 1. 添加自定義的 MessageConverter 進系統底層
     * 2. 系統底層就會統計出所有 MessageConverter 能操作哪些類型
     * 3. 客戶端內容協商 [客戶端要：xxx 類型數據 ---> 服務器給： xxx 類型數據]
     *
     * @return
     */
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
