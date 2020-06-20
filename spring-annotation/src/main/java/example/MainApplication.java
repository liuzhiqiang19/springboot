package example;

import bean.Person;
import config.AnnConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApplication
{
    public static void main(String[] args)
    {
        //获取配置类,创建容器
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AnnConfig.class);
        Person bean = annotationContext.getBean(Person.class);
        System.out.println(bean);
        //获取Person.class在容器中的名字
        String[] beanNamesForType = annotationContext.getBeanNamesForType(Person.class);
        for (String name: beanNamesForType)
        {
            System.out.println(name);
        }
    }
}
