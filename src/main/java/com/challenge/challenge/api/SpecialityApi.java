package com.challenge.challenge.api;

import com.challenge.challenge.dto.request.SpecialityRequest;
import com.challenge.challenge.dto.response.SpecialityResponse;
import com.challenge.challenge.utils.OpenApi3Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Api Specialities", description = "Api for details Specialities")
public interface SpecialityApi {

    @Operation(summary = "Create speciality in the database", description = "Create speciality in the database",
            tags = "Speciality", method = OpenApi3Constants.POST)
    @ApiResponse(responseCode = "201", description = OpenApi3Constants.MSG_STATUS_201)
    ResponseEntity<SpecialityResponse> create(SpecialityRequest specialityRequest);
}
