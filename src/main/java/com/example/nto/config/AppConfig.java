package com.example.nto.config;

import com.example.nto.repository.CodeRepository;
import com.example.nto.repository.EmployeeRepository;
import com.example.nto.service.CodeService;
import com.example.nto.service.EmployeeService;
import com.example.nto.service.impl.CodeServiceImpl;
import com.example.nto.service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceImpl(employeeRepository);
    }

    @Bean
    public CodeService codeService(CodeRepository codeRepository) {
        return new CodeServiceImpl(codeRepository);
    }
}
