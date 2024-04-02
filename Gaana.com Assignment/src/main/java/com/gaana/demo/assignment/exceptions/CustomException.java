package com.gaana.demo.assignment.exceptions;

import com.gaana.demo.assignment.enums.ErrorEnum;
import lombok.Getter;

@Getter
public class CustomException extends Exception {

    private ErrorEnum errorEnum;

    public CustomException(ErrorEnum errorEnum, String message) {
        super(message);
        this.errorEnum = errorEnum;
    }
}