package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Consult;
import com.challenge.challenge.domain.Doctor;
import com.challenge.challenge.domain.Patient;
import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.dto.request.ConsultRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class ConsultRequestToConsult implements Converter<ConsultRequest, Consult> {
    @Override
    public Consult convert(ConsultRequest source) {
        return ofNullable(source)
                .map(s -> Consult.builder()
                        .id(s.getId())
                        .patient(Patient.builder()
                                .id(s.getPatientId())
                                .build())
                        .doctor(Doctor.builder()
                                .id(s.getDoctorId())
                                .build())
                        .speciality(Speciality.builder()
                                .id(s.getSpecialityId())
                                .build())
                        .build())
                .orElse(null);
    }
}
