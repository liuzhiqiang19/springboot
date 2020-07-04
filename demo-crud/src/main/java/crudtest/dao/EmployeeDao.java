package crudtest.dao;

import crudtest.entities.Department;
import crudtest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
@Repository
public class EmployeeDao
{
    private static HashMap<Integer, Employee> employees;

//    @Autowired
//    private static DepartmentDao departmentDao; //第23行空指针异常，没有调构造器new对象???

    static
    {
        employees=new HashMap<>();
        DepartmentDao departmentDao = new DepartmentDao();
        employees.put(1,new Employee(1,"zhang",1,"zhang@bupt.edu.cn", new Date(), departmentDao.getDepartment(3)));
        employees.put(2,new Employee(2,"wang",0,"wang@bupt.edu.cn",new Date() , departmentDao.getDepartment(4)));
        employees.put(3,new Employee(3,"lin",1,"lin@bupt.edu.cn", new Date(), departmentDao.getDepartment(1)));
        employees.put(4,new Employee(4,"sun",0,"sun@bupt.edu.cn", new Date(), departmentDao.getDepartment(2)));
    }
    public Employee getEmployee(int id)
    {
        return employees.get(id);
    }
    public Collection<Employee> getEmployees()
    {
         return employees.values();
    }
    public void deleteEmployee(int id)
    {
        employees.remove(id);
    }
    private static int id=5;
    public void putEmployee(Employee employee)
    {
        if (employee.getId() == 0)  //基本数据类型有默认值，不能用null判断
        {
            employee.setId(id);
            id++;
        }
//        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));  //??
        employees.put(employee.getId(),employee);
    }
}
