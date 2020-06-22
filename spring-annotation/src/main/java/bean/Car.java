package bean;

public class Car
{
    public Car()
    {
        System.out.println("new对象car");
    }
    public void init()
    {
        System.out.println("初始化car");
    }
    public void destroy()
    {
        System.out.println("销毁car");
    }
}
