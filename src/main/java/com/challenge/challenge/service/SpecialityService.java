package com.challenge.challenge.service;

import com.challenge.challenge.domain.Speciality;

import java.util.List;

public interface SpecialityService {

    Speciality create(Speciality request);

    List<Speciality> getAll();
}
