package config;

import bean.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnConfig3
{
    @Bean("cfBean")
    public ColorFactoryBean colorFactoryBean()
    {
        ColorFactoryBean colorFactoryBean = new ColorFactoryBean();
        return colorFactoryBean;
    }
}
