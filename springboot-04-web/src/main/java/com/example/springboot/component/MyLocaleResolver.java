package com.example.springboot.component;

import org.apache.coyote.Request;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


//写自己的区域解析器 ，点击“中文”、“英文”实现中英文切换的国际化效果
public class MyLocaleResolver implements LocaleResolver
{
    @Override
    public Locale resolveLocale(HttpServletRequest request)
    {
        String l = request.getParameter("l");
        Locale locale= Locale.getDefault();
        if (!StringUtils.isEmpty(l))
        {
            String[] s = l.split("_");
            locale=new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale)
    {

    }
}
