package com.challenge.challenge.service.impl;

import com.challenge.challenge.domain.Pathology;
import com.challenge.challenge.repository.PathologyRepository;
import com.challenge.challenge.service.PathologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PathologyServiceImpl implements PathologyService {

    private final PathologyRepository repository;

    @Override
    public Pathology create(Pathology request) {
        return repository.save(request);
    }

    @Override
    public List<Pathology> getAll() {
        return repository.findAll();
    }
}
