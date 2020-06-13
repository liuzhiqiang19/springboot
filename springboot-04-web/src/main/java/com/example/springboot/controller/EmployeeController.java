package com.example.springboot.controller;

import com.example.springboot.dao.DepartmentDao;
import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entities.Department;
import com.example.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("emps",employees);
        return "emp/list";  //list.html
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model)
    {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments  );
        return "emp/add"; //add.html
    }
    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee)
    {
        employeeDao.save(employee);
        //redirect:重定向
        //forward: 转发
        return "redirect:/emps";
    }

}
