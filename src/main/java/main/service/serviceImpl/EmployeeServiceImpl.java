package main.service.serviceImpl;

import main.domain.converter.Converter;
import main.domain.dto.CreateEmployeeDto;
import main.domain.dto.DatesDto;
import main.domain.dto.DutyDto;
import main.domain.dto.EmployeeDto;
import main.domain.entity.Employee;
import main.domain.repository.EmployeeRepository;
import main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<DutyDto> random(DatesDto datesDto) {
        List<Date> a = new ArrayList<>();
        List<Integer> daysOfWeek = new ArrayList<>();
        for(String i: datesDto.getDays()) {
            if(i.equals("monday")) daysOfWeek.add(1);
            if(i.equals("tuesday")) daysOfWeek.add(2);
            if(i.equals("wednesday")) daysOfWeek.add(3);
            if(i.equals("thursday")) daysOfWeek.add(4);
            if(i.equals("friday")) daysOfWeek.add(5);
            if(i.equals("saturday")) daysOfWeek.add(6);
            if(i.equals("sunday")) daysOfWeek.add(0);

        }

        Date temp = new Date(datesDto.getStartDate().getTime());

        while(temp.before(datesDto.getEndDate()))
        {
            Date date = new Date(temp.getTime());
            if (daysOfWeek.contains(date.getDay()))
            {
                a.add(date);
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(temp);
            calendar.add(Calendar.DATE, 1);
            temp = calendar.getTime();

        }

        if(daysOfWeek.contains(temp.getDay()))
        {
            a.add(temp);
        }

        List<DutyDto> dutyDtos = new ArrayList<>();
        List<EmployeeDto> workers = findAll();
        Random r = new Random();
        int randomIndex;
        List<Integer> indexes = new ArrayList<>();

        for(Date date: a) {

            int i = 0;
            List<EmployeeDto> workersforDay = new ArrayList<>();
            while(i < datesDto.getAmountOfWorkers()) {

                if (indexes.size() == workers.size()) {
                    indexes.clear();
                }

                randomIndex = r.nextInt(workers.size());
                while(indexes.contains(randomIndex)) {
                    randomIndex = r.nextInt(workers.size());
                }

                if(!workersforDay.contains(workers.get(randomIndex)))
                {
                    workersforDay.add(workers.get(randomIndex));
                    indexes.add(randomIndex);
                    i++;
                }


            }

            dutyDtos.add(new DutyDto(date, workersforDay));
        }

        return dutyDtos;
    }
}
