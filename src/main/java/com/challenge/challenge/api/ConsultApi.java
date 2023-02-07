package com.challenge.challenge.api;

import com.challenge.challenge.dto.request.ConsultRequest;
import com.challenge.challenge.dto.response.ConsultResponse;
import com.challenge.challenge.utils.OpenApi3Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Api Consults", description = "Api for details Consults")
public interface ConsultApi {

    @Operation(summary = "Create consult in the database", description = "Create consult in the database",
            tags = "Consult", method = OpenApi3Constants.POST)
    @ApiResponse(responseCode = "201", description = OpenApi3Constants.MSG_STATUS_201)
    ResponseEntity<ConsultResponse> create(ConsultRequest consultRequest);
}
