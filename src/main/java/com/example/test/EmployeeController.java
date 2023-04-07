package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        employee.setEmpName("cndskcd");
        return employee;
    }

    @GetMapping
    public List<Employee> employeeList() {
        return employeeService.getAllEmployees();
    }
}
