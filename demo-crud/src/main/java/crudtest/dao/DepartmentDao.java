package crudtest.dao;

import crudtest.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
@Repository
public class DepartmentDao
{
    private static HashMap<Integer,Department> departments;

    public DepartmentDao()
    {
//        System.out.println("DepartmentDao空参构造器");
    }

    static
    {
        departments = new HashMap<>();
        departments.put(1,new Department("AA",1));
        departments.put(2,new Department("BB",2));
        departments.put(3,new Department("CC",3));
        departments.put(4,new Department("DD",4));
    }

    public Collection<Department> getDepartments()
    {
          return departments.values();
    }
    public Department getDepartment(int id)
    {
        return departments.get(id);
    }
}
