package com.example.employeemanagement.services;

import com.example.employeemanagement.dto.EmployeeRequestDTO;
import com.example.employeemanagement.dto.EmployeeResponseDTO;
import com.example.employeemanagement.entity.EmployeeGS;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;



//  Adding Employee
    @Transactional
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO dto){
        EmployeeGS emp=new EmployeeGS();
        emp.setName(dto.getName());
        emp.setDescription(dto.getDescription());
        emp.setSalary(dto.getSalary());
        emp.setEmail(dto.getEmail());
        emp.setGender(dto.getGender());
        emp.setStatus(dto.getStatus());

        EmployeeGS saved=repository.save(emp);
        return mapToDTO(saved);
    }


//    Update Employee
    @Transactional
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto){
        EmployeeGS emp=repository.findById(id)
                               .orElseThrow(()-> new EmployeeNotFoundException(id));
        emp.setName(dto.getName());
        emp.setDescription(dto.getDescription());
        emp.setSalary(dto.getSalary());
        emp.setEmail(dto.getEmail());
        emp.setGender(dto.getGender());
        emp.setStatus(dto.getStatus());

        return mapToDTO(repository.save(emp));

    }


//    Delete Employee
    @Transactional
    public void deleteEmployee(Long id){
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        repository.deleteById(id);
    }


//    Get Employee
    @Transactional(readOnly = true)
    public EmployeeResponseDTO getEmployee(Long id){
        EmployeeGS emp=repository.findById(id)
                               .orElseThrow(()-> new EmployeeNotFoundException(id));
        return mapToDTO(emp);
    }


//    Get All Employees
    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> getAllEmployees(){
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


//    Mapping Entity to DTO
    private EmployeeResponseDTO mapToDTO(EmployeeGS emp){
        EmployeeResponseDTO dto=new EmployeeResponseDTO();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setDescription(emp.getDescription());
        dto.setSalary(emp.getSalary());
        dto.setEmail(emp.getEmail());
        dto.setGender(emp.getGender());
        dto.setStatus(emp.getStatus());
        return dto;
    }
}
