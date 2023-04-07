package com.example.test;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    private Integer id;
    private String empName;
    private Date dob;
    @Transient
    private Long age;

    public String getEmpName() {
        return empName;
    }

    public Long getAge() {
        return age;
    }

    public Employee setAge(Long age) {
        this.age = age;
        return this;
    }

    public Employee setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Employee(Integer id, String empName, Date dob) {
        this.id = id;
        this.empName = empName;
        this.dob = dob;
    }

    public Employee() {
    }

    public Date getDob() {
        return dob;
    }

    public Employee setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }
}
