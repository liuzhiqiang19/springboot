package config;

import bean.Person;
import condition.LinuxCondition;
import condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration
public class AnnConfig2
{
    @Lazy
    @Scope
//    @Scope("prototype")
    @Bean("person1") //把方法加入容器，取名为person1
    public Person person()
    {
        Person person = new Person("liu",22);
        System.out.println("new对象已完成");
        return person;
    }

    @Bean("bill")
    @Conditional(WindowsCondition.class)
    public Person person2()
    {
        Person bill = new Person("bill", 33);
        return bill;
    }
    @Bean("linux")
    @Conditional(LinuxCondition.class)
    public Person person3()
    {
        Person linux = new Person("linux", 44);
        return linux;
    }

}
