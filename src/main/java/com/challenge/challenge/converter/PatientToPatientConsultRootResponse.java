package com.challenge.challenge.converter;

import com.challenge.challenge.domain.*;
import com.challenge.challenge.dto.response.PatientConsultResponse;
import com.challenge.challenge.dto.response.PatientConsultRootResponse;
import com.challenge.challenge.dto.response.SymptomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class PatientToPatientConsultRootResponse implements Converter<Patient, PatientConsultRootResponse> {

    private final ConversionService conversionService;

    @Override
    public PatientConsultRootResponse convert(Patient source) {
        return ofNullable(source)
                .map(s -> PatientConsultRootResponse.builder()
                        .consults(ofNullable(s.getConsults())
                                .map(this::convertConsultToPatientConsultResponse)
                                .orElse(null))
                        .symptoms(getSymptoms(s))
                        .build())
                .orElse(null);
    }

    private static List<SymptomResponse> getSymptoms(Patient patient) {
        List<Pathology> pathologies = ofNullable(patient.getPathologies()).orElse(Collections.emptyList());
        List<SymptomResponse> symptoms = new ArrayList<>();

        for (Pathology pathology : pathologies) {
            symptoms.addAll(getSymptomResponse(pathology));
        }

        return symptoms;
    }

    private static List<SymptomResponse> getSymptomResponse(Pathology pathology) {
        return pathology.getSymptoms().stream()
                .map(s -> SymptomResponse.builder()
                        .symptomId(s.getId())
                        .description(s.getDescription())
                        .build())
                .toList();
    }

    private List<PatientConsultResponse> convertConsultToPatientConsultResponse(Set<Consult> consult) {
        return consult.stream()
                .map(c -> PatientConsultResponse.builder()
                        .consultId(c.getId())
                        .doctorName(getDoctorName(c))
                        .specialityName(getSpecialityName(c))
                        .build())
                .toList();

    }

    private static String getSpecialityName(Consult c) {
        return ofNullable(c.getSpeciality())
                .map(Speciality::getName)
                .orElse(null);
    }

    private static String getDoctorName(Consult c) {
        return ofNullable(c.getDoctor())
                .map(Doctor::getName)
                .orElse(null);

    }
}
