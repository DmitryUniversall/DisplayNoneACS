package com.example.nto.service;

import com.example.nto.entity.Code;

import java.util.Optional;

public interface CodeService {
    Optional<Code> findByValue(long value);
}
