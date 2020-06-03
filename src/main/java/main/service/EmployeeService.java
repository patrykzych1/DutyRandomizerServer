package main.service;

import main.domain.dto.CreateEmployeeDto;
import main.domain.dto.DatesDto;
import main.domain.dto.DutyDto;
import main.domain.dto.EmployeeDto;

import java.util.Date;
import java.util.List;


public interface EmployeeService {
    List<EmployeeDto> findAll();

    void createEmployee(CreateEmployeeDto createEmployeeDto);

    void deleteEmployee(Long employeeId);

    List<DutyDto> random(DatesDto datesDto);
}
