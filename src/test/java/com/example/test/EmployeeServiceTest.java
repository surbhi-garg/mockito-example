package com.example.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    TestService testService;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() {
         Employee emp1 = spy( new Employee(1,"Surbhi", new Date(95,7, 24)));
//        doReturn(1).when(emp1).getId();
//        doReturn("Surbhi").when(emp1).getEmpName();
//        doReturn(new Date(95,7, 24)).when(emp1).getDob();
//        doReturn(emp1).when(emp1).setAge(Mockito.any());
//        emp1 = new Employee(1,"Surbhi", new Date(95,7, 24));
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        doReturn(employeeList).when(employeeRepository).findAll();
        List<Employee> result = employeeService.getAllEmployees();
        assertEquals(1, result.size());
        assertEquals(27, result.get(0).getAge());
        verify(testService, times(1)).sayHello();
    }

}