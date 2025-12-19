package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeRequestDTO;
import com.example.employeemanagement.dto.EmployeeResponseDTO;
import com.example.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping
    public EmployeeResponseDTO add(@RequestBody EmployeeRequestDTO dto){
        return service.addEmployee(dto);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO update(@PathVariable Long id,
                                      @RequestBody EmployeeRequestDTO dto) {
        return service.updateEmployee(id, dto);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }


    @GetMapping("/{id}")
    public EmployeeResponseDTO get(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        return service.getAllEmployees();
    }

}
