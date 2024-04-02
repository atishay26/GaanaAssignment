package com.gaana.demo.assignment.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorEnum {

    USER_NOT_FOUND("001", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("002", HttpStatus.INTERNAL_SERVER_ERROR);

    private String errorCode;
    private HttpStatus httpStatus;

    ErrorEnum(String errorCode, HttpStatus status) {
        this.errorCode = errorCode;
        this.httpStatus = status;
    }
}
