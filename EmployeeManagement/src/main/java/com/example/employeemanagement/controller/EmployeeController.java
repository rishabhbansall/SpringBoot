package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeRequestDTO;
import com.example.employeemanagement.dto.EmployeeResponseDTO;
import com.example.employeemanagement.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> add(@Valid @RequestBody EmployeeRequestDTO dto){
        EmployeeResponseDTO response = service.addEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@PathVariable Long id,
                                                      @Valid @RequestBody EmployeeRequestDTO dto) {
        EmployeeResponseDTO response = service.updateEmployee(id, dto);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> get(@PathVariable Long id) {
        EmployeeResponseDTO response = service.getEmployee(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAll() {
        List<EmployeeResponseDTO> employees = service.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

}
