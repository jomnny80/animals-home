package com.puppy.animals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "It's success!");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @GetMapping("/testParams")
    public String testParams(
        Map<String, Object> map,
        Model model,
        HttpServletRequest request,
        HttpServletResponse response
    ){
        map.put("map", "HelloMap");
        model.addAttribute("model", "HelloModel");
        request.setAttribute("request", "HelloRequest");

        Cookie cookie = new Cookie("cookie", "HelloCookie");
        response.addCookie(cookie);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(
        @RequestAttribute(value = "msg", required = false) String msg,
        @RequestAttribute(value = "code", required = false) Integer code,
        HttpServletRequest request
    ){
        Object msg1 = request.getAttribute("msg");
        Object model = request.getAttribute("model");
        Object map1 = request.getAttribute("map");
        Object request1 = request.getAttribute("request");



        Map<String, Object> map = new HashMap<>();
        map.put("request method msg", msg1);
        map.put("annotation msg", msg);
        map.put("code", code);

        map.put("model", model);
        map.put("map", map1);
        map.put("request", request1);
        return map;
    }
}
