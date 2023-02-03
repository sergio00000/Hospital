package com.challenge.challenge.service.impl;

import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.repository.SpecialityRepository;
import com.challenge.challenge.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository repository;
    @Override
    public Speciality create(Speciality request) {
        return repository.save(request);
    }
}
