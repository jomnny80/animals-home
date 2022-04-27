package com.puppy.animals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MatrixVariableController {

    // 1. 語法 /matrix/sell;low=34;brand=byd,audi,yd
    // 2. Spring Boot 默認禁用了矩陣變量功能
    // 3. 手動開啟 ---> 原理：對於路徑的處理，urlPathHelper 進行解析，
    //      removeSemicolonContent ( 移除分號內容 ) 支持矩陣變量的
    // 4. 矩陣變量必須有 url 路徑變量才能被解析
    @GetMapping("/matrix/{path}")
    public Map carsSell(
        @MatrixVariable("low") Integer low,
        @MatrixVariable("brand") List<String> brand,
        @PathVariable("path") String path
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(
        @MatrixVariable(value = "age", pathVar = "bossId") Long bossAge,
        @MatrixVariable(value = "age", pathVar = "empId") Long empAge
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
