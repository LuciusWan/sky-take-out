package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;

import java.util.ArrayList;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);
    Employee Insert(EmployeeDTO employeeDTO);

    ArrayList<Employee> select(Integer pageNum, Integer pageSize);
}
