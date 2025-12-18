package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeGS {
    private String EmpName;
    private String EmpID;
    private String Desc;
    private long Salary;

    // No-arg constructor for Jackson setter-based deserialization
    public EmployeeGS() {
    }

    @JsonCreator
    public EmployeeGS(
            @JsonProperty("EmpName") String empName,
            @JsonProperty("EmpID") String empID,
            @JsonProperty("Desc") String desc,
            @JsonProperty("Salary") long salary) {
        EmpName = empName;
        EmpID = empID;
        Desc = desc;
        Salary = salary;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }


    public long getSalary() {
        return Salary;
    }

    public void setSalary(long salary) {
        Salary = salary;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }
}
