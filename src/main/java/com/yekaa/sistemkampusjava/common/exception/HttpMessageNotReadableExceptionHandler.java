package com.yekaa.sistemkampusjava.common.exception;

import com.yekaa.sistemkampusjava.common.enums.ErrorCode;
import com.yekaa.sistemkampusjava.common.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class HttpMessageNotReadableExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> JSONErrorParseException(HttpMessageNotReadableException ex) {
        ErrorCode errorType = ErrorCode.JSON_PARSE_ERROR;

        List<String> errorMessages = Collections.singletonList(ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                errorType.getDescription(),
                errorType.name(),
                errorMessages,
                String.valueOf(HttpStatus.BAD_REQUEST.value()));

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
