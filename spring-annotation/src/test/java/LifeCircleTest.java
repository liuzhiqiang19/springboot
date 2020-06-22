import config.LifeCircleConf;
import org.junit.Test;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCircleTest
{
    @Test
    public void test()
    {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(LifeCircleConf.class);
        System.out.println("IOC已创建");
        Object car = annotationContext.getBean("car");
        annotationContext.close();
    }
}
