package main.domain.dto;

import main.domain.entity.Employee;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class DutyDto implements Serializable {
    private Date date;
    private List<EmployeeDto> employeeDto;

    public DutyDto(Date date, List<EmployeeDto> employeeDto) {
        this.date = date;
        this.employeeDto = employeeDto;
    }

    public List<EmployeeDto> getEmployeeDto() {
        return employeeDto;
    }

    public Date getDate() {
        return date;
    }
}
