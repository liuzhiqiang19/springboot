package crudtest.config;

import crudtest.interceptor.MyInterceptor;
import crudtest.myresolver.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyWebMvcConf implements WebMvcConfigurer
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/").setViewName("login"); //这里写"/login",idea运行正常，打包在命令行却不行...为什么
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/emps").setViewName("emp/list");
    }

    //拦截未登陆的路径
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/index");
    }
    //自定义区域视图解析器，注册到容器
    @Bean
    public LocaleResolver localeResolver()
    {
        return new MyLocalResolver();
    }
}
