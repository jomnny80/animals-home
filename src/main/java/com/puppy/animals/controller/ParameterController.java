package com.puppy.animals.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    // car/2/owner/lin
    @GetMapping("/car/{id}/owner/{name}")
    public Map<String, Object> getPathVariable(
        @PathVariable("id") Long id,
        @PathVariable("name") String name,
        @PathVariable Map<String, String> pv
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        return map;
    }

    @GetMapping("/header")
    public Map<String, Object> getRequestHeader(
        @RequestHeader("User-Agent") String userAgent,
        @RequestHeader Map<String, String> headers
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("userAgent", userAgent);
        map.put("headers", headers);
        return map;
    }

    @GetMapping("/param")
    public Map<String, Object> getRequestParam(
        @RequestParam("age") Integer age,
        @RequestParam("interesting") List<String> interesting,
        @RequestParam Map<String, String> params
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("age", age);
        map.put("interesting", interesting);
        map.put("params", params);
        return map;
    }

    @GetMapping("/cookie")
    public Map<String, Object> getCookieValue(
        @CookieValue("_ga") String _ga,
        @CookieValue("_ga") Cookie cookie
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("_ga", _ga);
        map.put("cookie", cookie);
        return map;
    }

    @PostMapping("/request-body")
    public Map<String, Object> getRequestBody(
        @RequestBody String content
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }
}
