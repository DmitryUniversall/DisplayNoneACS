package com.example.nto.service;

import com.example.nto.entity.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findByLogin(String login);
}
