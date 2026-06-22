package com.iuh.pharmacy_project.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomedException extends RuntimeException {
    private ErrorCode errorCode;

    public CustomedException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
