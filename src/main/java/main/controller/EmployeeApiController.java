package main.controller;

import main.domain.dto.CreateEmployeeDto;
import main.domain.dto.EmployeeDto;
import main.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value="/api")
public class EmployeeApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeApiController.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @CrossOrigin
    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<EmployeeDto>> getOnDutyList() {
        LOGGER.info("on duty list");

        List<EmployeeDto> employeeDtoList = employeeService.findAll();
        return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto){
        LOGGER.info("create employee: {}", createEmployeeDto);

        employeeService.createEmployee(createEmployeeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
