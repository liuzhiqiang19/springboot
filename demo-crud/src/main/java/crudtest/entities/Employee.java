package crudtest.entities;


import java.util.Date;

public class Employee
{
    private int id;
    private String name;
    private int gender;
    private String email;
    private Date birthday;
    private Department department;

    public Employee()
    {
    }

    public Employee(int id, String name, int gender, String email, Date birthday, Department department)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.birthday = birthday;
        this.department = department;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", department=" + department +
                '}';
    }
}
