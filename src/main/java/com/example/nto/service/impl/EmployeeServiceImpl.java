package com.example.nto.service.impl;

import com.example.nto.entity.Employee;
import com.example.nto.repository.EmployeeRepository;
import com.example.nto.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findByLogin(String login) {
        return employeeRepository.findByLogin(login);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
