package com.example.springboot.mapper;


import com.example.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

//配置版

@Mapper//或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
