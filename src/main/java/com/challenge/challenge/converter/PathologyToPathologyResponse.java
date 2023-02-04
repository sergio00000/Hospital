package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Pathology;
import com.challenge.challenge.dto.response.DoctorResponse;
import com.challenge.challenge.dto.response.PathologyResponse;
import com.challenge.challenge.dto.response.SpecialityResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class PathologyToPathologyResponse implements Converter<Pathology, PathologyResponse> {
    @Override
    public PathologyResponse convert(Pathology source) {
        return ofNullable(source)
                .map(s -> PathologyResponse.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .speciality(ofNullable(s.getSpeciality())
                                .map(sp -> SpecialityResponse.builder()
                                        .id(sp.getId())
                                        .name(sp.getName())
                                        .doctor(ofNullable(sp.getDoctor())
                                                .map(d -> DoctorResponse.builder()
                                                        .id(d.getId())
                                                        .name(d.getName())
                                                        .build())
                                                .orElse(null))
                                        .build())
                                .orElse(null))
                        .build())
                .orElse(null);
    }
}
