package com.example.employee.service;

import com.example.employee.model.EmployeeGS;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    private final ArrayList<EmployeeGS> employeeList = new ArrayList<>();
    public EmployeeService(){
        employeeList.add(new EmployeeGS("Rahul","e001","java developer",50000));
        employeeList.add(new EmployeeGS("Amit","e002","python developer",60000));
        employeeList.add(new EmployeeGS("Sonia","e003","full stack developer",70000));
        employeeList.add(new EmployeeGS("Neha","e004","frontend developer",55000));
        employeeList.add(new EmployeeGS("Rohit","e005","backend developer",65000));
    }
    public ArrayList<EmployeeGS> getAllEmployees(){
        return employeeList;
    }

    public boolean createEmployee(EmployeeGS employee){
        return employeeList.add(employee);
    }

}
