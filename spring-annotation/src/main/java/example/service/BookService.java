package example.service;

import example.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService
{
    @Qualifier("bookDao") //指定装配的对象
//    @Autowired
    @Autowired(required = false)
    private BookDao bookDao;

    @Override
    public String toString()
    {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
