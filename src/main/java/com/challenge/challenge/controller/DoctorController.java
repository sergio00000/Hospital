package com.challenge.challenge.controller;

import com.challenge.challenge.api.DoctorApi;
import com.challenge.challenge.dto.response.DoctorResponse;
import com.challenge.challenge.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_VALUE)
public class DoctorController implements DoctorApi {

    private final DoctorService doctorService;
    private final ConversionService conversionService;

    @GetMapping("/doctors/{id}")
    @Override
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable UUID doctorId) {
        DoctorResponse response = this.conversionService.convert(doctorService.getDoctorById(doctorId), DoctorResponse.class);
        return new ResponseEntity<>(response, OK);
    }

}

