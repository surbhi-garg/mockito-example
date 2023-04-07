package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class EventListeners {

    @Autowired
    private EmployeeRepository employeeRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onContextRefresh() {
        Employee emp1 = new Employee(1,"Surbhi", new Date(95,7, 24));
        Employee emp2 = new Employee(2, "Dheeraj", new Date(90,2, 5));
        Employee emp3 = new Employee(3, "Himani", new Date(97,3, 24));
        Employee emp4 = new Employee(4, "Himanshu", new Date(97,9, 12));
        employeeRepository.saveAll(Arrays.asList(emp1, emp2, emp3, emp4));
    }
}
