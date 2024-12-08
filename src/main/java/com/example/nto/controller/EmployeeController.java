package com.example.nto.controller;

import com.example.nto.service.CodeService;
import com.example.nto.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CodeService codeService;

    @Autowired
    public EmployeeController(EmployeeService userService, CodeService codeService) {
        this.employeeService = userService;
        this.codeService = codeService;
    }

    @GetMapping("/{login}/auth")
    public ResponseEntity<?> authenticateUser(@PathVariable String login) {
        return employeeService.findByLogin(login)
                .map(user -> ResponseEntity.ok("Ok"))
                .orElse(ResponseEntity.status(401).body("Unknown login"));
    }

    @GetMapping("/{login}/info")
    public ResponseEntity<?> getUserInfo(@PathVariable String login) {
        return employeeService.findByLogin(login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    @PatchMapping("/{login}/open")
    public ResponseEntity<?> open(@PathVariable String login, @RequestBody Map<String, String> payload) {
        long codeValue;

        try {
            codeValue = Long.parseLong(payload.get("value"));
        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("Bad code format");
        }

        return employeeService.findByLogin(login)
                .map(user -> {
                    return codeService.findByValue(codeValue)
                            .map(code -> ResponseEntity.ok("Ok"))
                            .orElse(ResponseEntity.status(400).body("Unknown code"));
                })
                .orElse(ResponseEntity.status(401).body("Unknown login"));
    }
}
