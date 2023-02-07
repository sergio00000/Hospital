package com.challenge.challenge.service;

import com.challenge.challenge.domain.Symptom;

import java.util.List;

public interface SymptomService {
    List<Symptom> getAll();

    Symptom create(Symptom request);
}
