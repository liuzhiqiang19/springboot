package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController
{
    @PostMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session)
    {
        if (!StringUtils.isEmpty(username) && "123456".equals(password))
        {
            //            return "dashboard"; //登录成功
            //登录成功以后，防止表单提交，重定向
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else
        {
            map.put("msg", "用户名/密码错误");
            return "login";     //登录失败
        }
    }
}
