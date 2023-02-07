package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Doctor;
import com.challenge.challenge.dto.request.DoctorRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class DoctorRequestToDoctor implements Converter<DoctorRequest, Doctor> {
    @Override
    public Doctor convert(DoctorRequest source) {
        return ofNullable(source)
                .map(s -> Doctor.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .build())
                .orElse(null);
    }
}
