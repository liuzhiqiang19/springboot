package config;

import bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/person.properties")
public class ValueConf
{
    @Bean
    public Person person()
    {
        return new Person();
    }
}
