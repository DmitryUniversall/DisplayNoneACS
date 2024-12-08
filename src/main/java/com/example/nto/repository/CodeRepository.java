package com.example.nto.repository;

import com.example.nto.entity.Code;
import com.example.nto.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeRepository extends JpaRepository<Code, Long> {
    Optional<Code> findByValue(long value);
}
