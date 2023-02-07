package com.challenge.challenge.controller;

import com.challenge.challenge.api.ConsultApi;
import com.challenge.challenge.domain.Consult;
import com.challenge.challenge.dto.request.ConsultRequest;
import com.challenge.challenge.dto.response.ConsultResponse;
import com.challenge.challenge.service.ConsultService;
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
@RequestMapping(value = "/v1/consults", produces = APPLICATION_JSON_VALUE)
public class ConsultController implements ConsultApi {
    private final ConversionService conversionService;

    private final ConsultService service;

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConsultResponse> create(@RequestBody ConsultRequest request) {
        Consult consult = service.create(conversionService.convert(request, Consult.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(conversionService.convert(consult, ConsultResponse.class));
    }
}
