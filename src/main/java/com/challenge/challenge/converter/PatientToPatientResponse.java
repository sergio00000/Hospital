package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Patient;
import com.challenge.challenge.dto.response.PatientResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class PatientToPatientResponse implements Converter<Patient, PatientResponse> {
    @Override
    public PatientResponse convert(Patient source) {
        return ofNullable(source)
                .map(s -> PatientResponse.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .dateOfBirth(s.getDateOfBirth())
                        .build())
                .orElse(null);
    }
}
