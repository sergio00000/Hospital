package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Patient;
import com.challenge.challenge.dto.request.PatientRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class PatientRequestToPatient implements Converter<PatientRequest, Patient> {
    @Override
    public Patient convert(PatientRequest source) {
        return ofNullable(source)
                .map(s -> Patient.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .dateOfBirth(s.getDateOfBirth())
                        .build())
                .orElse(null);
    }
}
