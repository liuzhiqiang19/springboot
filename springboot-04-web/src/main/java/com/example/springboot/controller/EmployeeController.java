package com.example.springboot.controller;

import com.example.springboot.dao.DepartmentDao;
import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entities.Department;
import com.example.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController
{
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查所有员工
    @GetMapping("emps")
    public String list(Model model)
    {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";  //list.html
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model)
    {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add"; //add.html
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee)
    {
        //来到员工列表页面
        employeeDao.save(employee);
        //redirect:重定向
        //forward: 转发
        return "redirect:/emps";
    }

    //来到修改页面，查找员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model)
    {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //查部门，页面显示所有部门的列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        //回到修改页面(add.html可改可增)
        return "emp/add";
    }

    //员工修改功能
    @PutMapping("/emp")
    public String updateEmployee(Employee employee)
    {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除功能
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id)
    {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
