package com.challenge.challenge.api;

import com.challenge.challenge.dto.request.PatientRequest;
import com.challenge.challenge.dto.response.PatientResponse;
import com.challenge.challenge.utils.OpenApi3Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Api Patient", description = "Api for details Patient")
public interface PatientApi {

    @Operation(summary = "Create patient in the database", description = "Create patient in the database",
            tags = "Patient", method = OpenApi3Constants.POST)
    @ApiResponse(responseCode = "201", description = OpenApi3Constants.MSG_STATUS_201)
    ResponseEntity<PatientResponse> create(PatientRequest patientRequest);
}
