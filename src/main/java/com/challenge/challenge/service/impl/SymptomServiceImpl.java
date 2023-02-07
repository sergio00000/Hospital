package com.challenge.challenge.service.impl;

import com.challenge.challenge.domain.Symptom;
import com.challenge.challenge.repository.SymptomRepository;
import com.challenge.challenge.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomServiceImpl implements SymptomService {
    private final SymptomRepository repository;
    @Override
    public List<Symptom> getAll() {
        return repository.findAll();
    }

    @Override
    public Symptom create(Symptom request) {
        return repository.save(request);
    }
}
