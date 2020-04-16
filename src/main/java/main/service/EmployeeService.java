package main.service;

import main.domain.dto.CreateEmployeeDto;
import main.domain.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDto> findAll();

    void createEmployee(CreateEmployeeDto createEmployeeDto);
}
