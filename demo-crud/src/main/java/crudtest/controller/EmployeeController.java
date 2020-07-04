package crudtest.controller;

import crudtest.dao.DepartmentDao;
import crudtest.dao.EmployeeDao;
import crudtest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController
{
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //点击员工管理，来到list页面,展示所有的员工列表
    @GetMapping("/emps")
    public String getEmployees(Model model)
    {
        model.addAttribute("employees", employeeDao.getEmployees());
        return "emp/list";
    }
    //点击添加员工，来到add页面，查询所有的部门
    @GetMapping("/addemployee")
    public String toAddPage(Model model)
    {
        model.addAttribute("departments",departmentDao.getDepartments());
        return "emp/add";
    }
    //添加员工
    @PostMapping("/addemployee")
    public String addEmployees(Employee employee)
    {
        employeeDao.putEmployee(employee);
//        return "emp/list";  //不会重新获取员工信息
        return "redirect:/emps";
    }
    //来到修改页面
    @GetMapping("/addemployee/{id}")
    public  String toAddPage(Model model,@PathVariable int id)
    {
        model.addAttribute("employee",employeeDao.getEmployee(id));
        //查询显示所有部门
        model.addAttribute("departments",departmentDao.getDepartments());
        return "emp/add";
    }
    //修改员工
    @PutMapping("/addemployee")
    public String updateEmployee(Employee employee)
    {
        employeeDao.putEmployee(employee);
        return "redirect:/emps";
    }
    //删除员工
    @DeleteMapping("/delete_employee/{id}")
    public String deleteEmployee(@PathVariable("id") int id)
    {
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";  //重定向的需要加"/",其他的不用?(cmd运行)
//        - "/" 表示绝对路径
//                - 被浏览器解析：/==http://ip:port/
//                - 被服务器解析：/==http://ip:port/工程路径

    }
}
