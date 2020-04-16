package main.domain.mapper;

import main.domain.converter.Converter;
import main.domain.dto.CreateEmployeeDto;
import main.domain.entity.Employee;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class EmployeeMapper implements Converter<CreateEmployeeDto, Employee>{
    @Override
    public Employee convert(CreateEmployeeDto createEmployeeDto) {
        Employee employee = new Employee();
        employee.setName(createEmployeeDto.getName());
        employee.setSurname(createEmployeeDto.getSurname());

        return employee;
    }
}
