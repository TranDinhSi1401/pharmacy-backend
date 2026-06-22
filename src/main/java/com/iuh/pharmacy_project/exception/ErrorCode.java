package com.iuh.pharmacy_project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    CUSTOMER_NOT_FOUND(404, "customer not found");

    private final int code;
    private final String message;
}
