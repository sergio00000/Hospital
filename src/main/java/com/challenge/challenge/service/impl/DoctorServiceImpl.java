package com.challenge.challenge.service.impl;

import com.challenge.challenge.domain.Doctor;
import com.challenge.challenge.repository.DoctorRepository;
import com.challenge.challenge.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    public Doctor getDoctorById(UUID doctorId) {
        return repository.findById(doctorId)
                .orElse(null);
    }

    @Override
    public Doctor create(Doctor request) {
        return repository.save(request);
    }
}
