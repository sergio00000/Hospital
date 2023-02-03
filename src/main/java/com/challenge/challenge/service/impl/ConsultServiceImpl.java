package com.challenge.challenge.service.impl;

import com.challenge.challenge.domain.Consult;
import com.challenge.challenge.repository.ConsultRepository;
import com.challenge.challenge.service.ConsultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl implements ConsultService {

    private final ConsultRepository repository;
    @Override
    public Consult create(Consult request) {
        return repository.save(request);
    }
}
