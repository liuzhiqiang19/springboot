package config;

import example.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("example")
public class AutowiredConf
{
    @Bean("bookDao2")
    @Primary
    public BookDao bookDao()
    {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
