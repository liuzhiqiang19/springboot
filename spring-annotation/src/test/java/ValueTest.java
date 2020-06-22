import bean.Person;
import config.ValueConf;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ValueTest
{
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ValueConf.class);
    //获取容器中所有组件的名字
    private void printBeans(AnnotationConfigApplicationContext applicationContext)
    {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames)
        {
            System.out.println(name);
        }
    }
    @Test
    public void test()
    {
        printBeans(applicationContext);
        System.out.println("************");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
        applicationContext.close();
    }
}
