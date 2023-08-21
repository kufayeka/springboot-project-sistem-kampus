package com.yekaa.sistemkampusjava.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    VALIDATION_ERROR("Validation Error"),
    JSON_PARSE_ERROR("JSON Parse Error"),
    RESOURCE_NOT_FOUND("Resource Not Found"),
    UNAUTHORIZED("Unauthorized"),
    FORBIDDEN("Forbidden"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    ;

    private final String description;
}
