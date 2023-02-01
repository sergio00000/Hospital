package com.challenge.challenge.api;

import com.challenge.challenge.dto.response.DoctorResponse;
import com.challenge.challenge.utils.OpenApi3Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "Api Doctor", description = "Api for details Doctor by id")
public interface DoctorApi {

    @Operation(description = "Get Doctor by id",
            tags = "Doctor",
            method = OpenApi3Constants.GET)
    @ApiResponse(responseCode = "200", description = OpenApi3Constants.MSG_STATUS_200)
    ResponseEntity<DoctorResponse> getDoctorById(
            @Parameter(required = true, description = "Doctor id") UUID doctorId);
}
