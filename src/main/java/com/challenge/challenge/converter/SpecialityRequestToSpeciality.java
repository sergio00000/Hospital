package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Doctor;
import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.dto.request.SpecialityRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class SpecialityRequestToSpeciality implements Converter<SpecialityRequest, Speciality> {
    @Override
    public Speciality convert(SpecialityRequest source) {
        return ofNullable(source)
                .map(s -> Speciality.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .doctor(ofNullable(s.getDoctor())
                                .map(d -> Doctor.builder()
                                        .id(d.getId())
                                        .build())
                                .orElse(null))
                        .build())
                .orElse(null);
    }
}
