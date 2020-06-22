package config;

import bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("bean")
public class LifeCircleConf
{
    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car()
    {
        return new Car();
    }
}
