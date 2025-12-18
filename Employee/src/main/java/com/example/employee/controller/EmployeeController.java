package com.example.employee.controller;


import com.example.employee.model.EmployeeGS;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    
    // Use field injection as requested
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeGS> getAllEmployees(){
        return employeeService.getAllEmployees();

    }

    @PostMapping
    public boolean createEmployee(@RequestBody EmployeeGS newEmployee){
        return employeeService.createEmployee(newEmployee);
    }

}
