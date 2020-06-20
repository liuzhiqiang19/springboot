import config.AnnConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest
{
    @Test
    public void test1()
    {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AnnConfig.class);
        String[] beanDefinitionNames = annotationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames)
        {
            System.out.println(name);
        }
    }
}
