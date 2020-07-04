[TOC]
document.cookie ="thu_ip_flag=yes"
### 组件注册
    - 用配置类替换xml文件
    - @ComponentScan    (写在类上面)
        - 可以同时写多个@ComponentScan，也可写多个@ComponentScan.Filter
        - 过滤有includeFilters、excludeFilters
        - FilterType.ANNOTATION：按注解过滤
        - FilterType.GEGEX：按正则表达式过滤
        - FilterType.CUSTOM：自定义过滤规则
    - @Scope    (写在方法上面)
        - @Scope("prototype")，多实例，懒汉式(获取实例时才new对象)
        - @Scope，单实例，饿汉式(IOC容器启动后，立即new对象加入容器)
    - @lazy，懒汉式，获取实例的时候才创建对象   (写在方法上面，给默认的@Scope用的)
    - @Conditinal   (写在方法、类上面)
        - @Conditional(LinuxCondition.class) 按条件把对象加入容器
        - LinuxCondition需实现Condition接口并重写其方法
        - 该方法返回true，把对象加入容器
        - 写在类上面，满足条件整个配置类才生效

    - @Import   (写在配置类上面)
        - @Import({Color.class, Red.class})
        - **@Import(MyImportSelector.class)**，自定义类MyImportSelector需实现ImportSelector
        - @Import({MyImportBeanDefinitionRegistrar.class,Color.class, Red.class})，MyImportBeanDefinitionRegistrar.class需实现ImportBeanDefinitionRegistrar

```java
public class MyImportSelector implements ImportSelector //实现ImportSelector
{
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata)
    {
        String[] strings = new String[]{"bean.Color", "bean.Red"};
        return strings; //返回需要导入容器的对象所组成的数组
    }
}
```
    - 使用FactoryBean导入组件，自定义类实现FactoryBean

### 生命周期

- bean的创建、初始化、销毁
    - 创建
        - 单实例：IOC容器启动，bean对象即创建
        - 多实例：IOC容器启动并且获取bean对象时，才创建
    - 初始化
        - @Bean(initMethod = "init",destroyMethod = "destroy")，指定初始化、销毁方法，创建对象后自动初始化(这俩方法写在bean对象所属的类中)
    - 销毁
        - 单实例：容器关闭时，bean被销毁
        - 多实例：需主动销毁

- 初始化、销毁(ii)
    - 实现InitializingBean, DisposableBean

- 初始化、销毁(iii)
    - 不用@Bean指定方法，用下面的注解
    - @PostConstruct:写在"init"方法的上面
    - @PreDestroy：写在"destroy"方法的上面

- 初始化(iv)
    - 自定义类实现BeanPostProcessor，重写方法，加入容器(@Component--@ComponentScan,或者@Bean)
    - postProcessBeforeInitialization：初始化之前的处理
    - postProcessAfterInitialization：初始化之后的处理

- @Bean  把方法的返回值加入容器

### 属性赋值
- @Value
    - @Value("liu")     (Person类中)
    - @Value("#{20+2}")     (Person类中)
    - @Value("${person.nickName}")
        - @PropertySource(value={"classpath:/person.properties"})   (配置类中，类上面)
        - @Value("${person.nickName}")      (Person类中)

- @ConfigurationProperties
    - 支持批量导入、校验、复杂类型数据(map、list),首选
    - @Value功能少，适合单个属性的赋值

### 自动装配
- @Autowired 自动注入
    - 默认按类型去容器找组件
    - 多个组件类型相同，按id查找(bookDao、bookDao2)
    - @Primary 该组件是首选的
    - @Qualifier("bookDao2") 指定装配的对象
    - @Autowired(required = false) 装配的对象不存在时返回null，不会报异常
    - 通常写在属性上面，还可以放在构造器、方法、参数上，都是从容器中取值

### 注解释义
| 注解        | 含义                                        |
| ----------- | -------------------------------------------|
| @Component  | 最普通的组件，可以被注入到spring容器进行管理  |
| @Repository | 作用于持久层Dao                             |
| @Service    | 作用于业务逻辑层                            |
| @Controller | 作用于表现层,控制层                         |
