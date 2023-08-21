package com.yekaa.sistemkampusjava.common.exception;

import com.yekaa.sistemkampusjava.common.enums.ErrorCode;
import com.yekaa.sistemkampusjava.common.response.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class DataValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorCode errorType = ErrorCode.VALIDATION_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                errorType.getDescription(),
                errorType.name(),
                errorMessages,
                String.valueOf(HttpStatus.BAD_REQUEST.value()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
