package main.domain.mapper;



import main.domain.converter.Converter;
import main.domain.dto.EmployeeDto;
import main.domain.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeListMapper implements Converter<List<Employee>, List<EmployeeDto>> {
    @Override
    public List<EmployeeDto> convert(List<Employee> from) {
        return from.stream()
                .map(onDuty -> {
                    EmployeeDto employeeDto = new EmployeeDto();

                    employeeDto.setId(onDuty.getId());
                    employeeDto.setName(onDuty.getName());
                    employeeDto.setSurname(onDuty.getSurname());

                    return employeeDto;
                }).collect(Collectors.toList());
    }
}
