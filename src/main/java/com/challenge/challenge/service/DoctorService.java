package com.challenge.challenge.service;

import com.challenge.challenge.domain.Doctor;

import java.util.UUID;

public interface DoctorService {

    Doctor getDoctorById(UUID doctorId);
}
