package com.example.springboot.config;

import com.example.springboot.component.LoginHandlerInterceptor;
import com.example.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展springMVC
@Configuration  //添加@configuration
public class MyMvcConfig implements WebMvcConfigurer
{
//    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer()
//    {
//
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        //发送"hi"，也返回hello页面
        registry.addViewController("/hi").setViewName("success");
    }

    //跳转到动态的首页
    //所有的WebMvcConfigurer都会起作用
    @Bean     //将组件注册到容器
    public WebMvcConfigurer webMvcConfigurer()
    {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer()
        {

            @Override
            public void addViewControllers(ViewControllerRegistry registry)
            {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");//登录成功以后，防止表单提交，重定向
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry)
            {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login");
            }
        };
        return webMvcConfigurer;
    }

    @Bean    //把自己写的区域视图解析器加入到容器中
    public LocaleResolver localeResolver()
    {
        return new MyLocaleResolver();
    }
}
