package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.dto.response.DoctorResponse;
import com.challenge.challenge.dto.response.SpecialityResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class SpecialityToSpecialityResponse implements Converter<Speciality, SpecialityResponse> {
    @Override
    public SpecialityResponse convert(Speciality source) {
        return ofNullable(source)
                .map(s -> SpecialityResponse.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .doctor(ofNullable(s.getDoctor())
                                .map(d -> DoctorResponse.builder()
                                        .id(d.getId())
                                        .build())
                                .orElse(null))
                        .build())
                .orElse(null);
    }
}
