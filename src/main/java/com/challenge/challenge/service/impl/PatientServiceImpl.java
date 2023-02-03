package com.challenge.challenge.service.impl;

import com.challenge.challenge.domain.Patient;
import com.challenge.challenge.repository.PatientRepository;
import com.challenge.challenge.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Override
    public Patient create(Patient request) {
        return repository.save(request);
    }
}
