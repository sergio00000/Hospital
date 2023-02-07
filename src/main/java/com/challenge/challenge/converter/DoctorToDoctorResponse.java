package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Doctor;
import com.challenge.challenge.dto.response.DoctorResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class DoctorToDoctorResponse implements Converter<Doctor, DoctorResponse> {

    @Override
    public DoctorResponse convert(Doctor source) {
        return ofNullable(source)
                .map(s -> DoctorResponse.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .build())
                .orElse(null);
    }
}
