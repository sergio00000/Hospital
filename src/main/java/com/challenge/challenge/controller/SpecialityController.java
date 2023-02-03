package com.challenge.challenge.controller;

import com.challenge.challenge.api.SpecialityApi;
import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.dto.request.SpecialityRequest;
import com.challenge.challenge.dto.response.SpecialityResponse;
import com.challenge.challenge.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/specialities", produces = APPLICATION_JSON_VALUE)
public class SpecialityController implements SpecialityApi {
    private final ConversionService conversionService;

    private final SpecialityService service;

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SpecialityResponse> create(@RequestBody SpecialityRequest request) {
        Speciality speciality = service.create(conversionService.convert(request, Speciality.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(conversionService.convert(speciality, SpecialityResponse.class));
    }
}
