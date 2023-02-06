package com.challenge.challenge.service;

import com.challenge.challenge.domain.Patient;

import java.util.UUID;

public interface PatientService {
    Patient create(Patient request);
    Patient getPatientById(UUID id);
}
