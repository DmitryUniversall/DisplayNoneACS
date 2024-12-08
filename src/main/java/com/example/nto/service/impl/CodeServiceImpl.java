package com.example.nto.service.impl;

import com.example.nto.entity.Code;
import com.example.nto.repository.CodeRepository;
import com.example.nto.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CodeServiceImpl implements CodeService {
    private final CodeRepository codeRepository;

    @Autowired
    public CodeServiceImpl(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    public Optional<Code> findByValue(long value) {
        return codeRepository.findByValue(value);
    }
}
