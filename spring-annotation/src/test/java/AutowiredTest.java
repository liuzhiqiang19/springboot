import config.AutowiredConf;
import example.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest
{
    @Test
    public void test()
    {
        AnnotationConfigApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(AutowiredConf.class);
        BookService bean = annotationContext.getBean(BookService.class);
        System.out.println(bean);
    }
}
