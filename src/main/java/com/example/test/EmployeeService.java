package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TestService testService;

    public List<Employee> getAllEmployees() {
        testService.sayHello();
        testService.sayHello();
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(emp ->
                        emp.setAge(ChronoUnit.YEARS.between(
                        LocalDate.ofInstant(emp.getDob().toInstant(), ZoneId.systemDefault()),
                        LocalDate.ofInstant(new Date().toInstant(), ZoneId.systemDefault())))
                )
                .collect(Collectors.toList());
    }
}
