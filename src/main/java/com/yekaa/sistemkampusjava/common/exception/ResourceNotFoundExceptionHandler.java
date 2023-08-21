package com.yekaa.sistemkampusjava.common.exception;

import com.yekaa.sistemkampusjava.common.enums.ErrorCode;
import com.yekaa.sistemkampusjava.common.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.Collections;

@RestControllerAdvice
public class ResourceNotFoundExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            HttpClientErrorException.NotFound ex,
            HttpServletRequest request) {

        ErrorCode errorType = ErrorCode.RESOURCE_NOT_FOUND;

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                errorType.getDescription(),
                errorType.name(),
                Collections.singletonList(ex.getMessage()),
                String.valueOf(HttpStatus.NOT_FOUND.value()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
