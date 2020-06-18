package com.example.springboot.controller;

import com.example.springboot.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController
{
//跳转到动态的首页
//    @RequestMapping({"/","/index.html"})
//    public String index()
//    {
//        return "login";
//    }

    @ResponseBody
    @RequestMapping("/hello")   //发送"hello"请求，返回"返回 hello world"
    public String hello(@RequestParam("user") String user)
    {
        if (user.equals("aa"))
        {
            throw new UserNotFoundException();
        }
        return "返回 hello world";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map)
    {
        map.put("hiya", "<h1>shi ni ya</h1>");
        map.put("users", Arrays.asList("liu", "li", "wen"));
        return "success";
    }
}
