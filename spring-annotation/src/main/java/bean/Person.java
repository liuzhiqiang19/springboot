package bean;

import org.springframework.beans.factory.annotation.Value;

public class Person
{
    @Value("liu")
    String name;
    @Value("#{22-2}")
    int age;
    @Value("${person.nickName}")
    String nickName;
    public Person()
    {
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String nickName)
    {
        this.name = name;
        this.age = age;
        this.nickName = nickName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
