package crudtest.entities;

public class Department
{
    private String departmentName;
    private int id;

    public Department()
    {
    }

    public Department(String departmentName, int id)
    {
        this.departmentName = departmentName;
        this.id = id;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", id=" + id +
                '}';
    }
}
