package crudtest.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController
{
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Map<String,Object> map)
    {
        if (!StringUtils.isEmpty(username)&& ("123456".equals(password)))
        {
            session.setAttribute("username",username);
            return "redirect:/emps";
        }
        else
        {
            map.put("msg","用户名 or 密码错误");
            return "login";
        }
    }
}
