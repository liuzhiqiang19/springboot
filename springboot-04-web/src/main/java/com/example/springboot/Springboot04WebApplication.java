package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class Springboot04WebApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Springboot04WebApplication.class, args);
    }

    //定制ViewResolver：给容器添加自己的视图解析器，自动组合进来
    @Bean   //添加到容器
    public ViewResolver myViewResolver()
    {
        return new myViewResolver();
    }
    private static class myViewResolver implements ViewResolver
    {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception
        {
            return null;
        }
    }

}
