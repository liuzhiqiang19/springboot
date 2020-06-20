package config;

import bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan(value = "example") //扫描包：example

//排除指定类型的组件
//@ComponentScan(value = "example",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
//})
//只包含指定类型的组件
@ComponentScan(value = "example",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
public class AnnConfig
{
    @Bean("person1") //把方法加入容器，取名为person1
    public Person person()
    {
        Person person = new Person("liu",22);
        return person;
    }
}
