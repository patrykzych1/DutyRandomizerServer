package main.service.serviceImpl;

import main.domain.converter.Converter;
import main.domain.dto.CreateEmployeeDto;
import main.domain.dto.EmployeeDto;
import main.domain.entity.Employee;
import main.domain.repository.EmployeeRepository;
import main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Converter<List<Employee>, List<EmployeeDto>> employeeListMapper;
    private final Converter<CreateEmployeeDto, Employee> employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, Converter<List<Employee>, List<EmployeeDto>> employeeListMapper, Converter<CreateEmployeeDto, Employee> employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeListMapper = employeeListMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> onDutyList = employeeRepository.findAll();
        return employeeListMapper.convert(onDutyList);
    }

    @Override
    public void createEmployee(CreateEmployeeDto createEmployeeDto) {
        Employee employee = employeeMapper.convert(createEmployeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        employeeOptional.ifPresent(employeeRepository::delete);
    }
}
