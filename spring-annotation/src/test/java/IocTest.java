import bean.ColorFactoryBean;
import bean.Person;
import config.AnnConfig;
import config.AnnConfig2;
import config.AnnConfig3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IocTest
{
    @Test
    public void test()
    {
        //获取配置类,创建容器
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AnnConfig.class);
        System.out.println("IOC容器已经创建");
        Person bean = annotationContext.getBean(Person.class);
        System.out.println(bean);
        //获取Person.class在容器中的名字
        String[] beanNamesForType = annotationContext.getBeanNamesForType(Person.class);
        for (String name: beanNamesForType)
        {
            System.out.println("组件的名字："+name);
        }
    }
    @Test
    public void test1()
    {
//@ComponentScan测试
        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(AnnConfig.class);
        //获取容器中所有组件的名字
        String[] beanDefinitionNames = annotationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames)
        {
            System.out.println(name);
        }
    }
    @Test
    public void test3()
    {
 //@scope测试,配置类是AnnConfig2.class
        AnnotationConfigApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(AnnConfig2.class);
        System.out.println("IOC容器已创建");
//        Object bean = annotationContext.getBean("person1");//对于懒汉式，获取实例的时候才new对象
//        Object bean1 = annotationContext.getBean("person1"); //每获取一次,就new一个对象
//        System.out.println(bean==bean1);
    }

    @Test
    public void test4()
    {
   //@Conditional测试
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AnnConfig2.class);
        //获取运行环境，即操作系统 的名字
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        //获取容器中所有组件的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames)
        {
            System.out.println(name);
        }
        System.out.println("*****************");
        //按类型获取组件，即查找Person的对象有哪些加入了容器
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
    @Test
    public void test5()
    {
   //@Import测试
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AnnConfig2.class);
        //获取容器中所有组件的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames)
        {
            System.out.println(name);
        }
    }
    @Test
    public void test6()
    {
   //FactoryBean测试
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AnnConfig3.class);
        //获取工厂bean调用getObject创建的对象
        Object colorFactoryBean = applicationContext.getBean("cfBean");
        Object colorFactoryBean1 = applicationContext.getBean("cfBean");
        System.out.println("bean的类型："+colorFactoryBean.getClass());
        System.out.println(colorFactoryBean==colorFactoryBean1);
        //获得工厂bean本身
        Object colorFactoryBean2 = applicationContext.getBean("&cfBean");
        Object colorFactoryBean3 = applicationContext.getBean(ColorFactoryBean.class);
        System.out.println("****************************");
        System.out.println(colorFactoryBean2);
        System.out.println(colorFactoryBean3);
    }
}
