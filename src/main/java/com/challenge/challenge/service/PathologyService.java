package com.challenge.challenge.service;

import com.challenge.challenge.domain.Pathology;

import java.util.List;

public interface PathologyService {
    Pathology create(Pathology request);

    List<Pathology> getAll();
}
