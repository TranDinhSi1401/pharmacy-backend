package com.iuh.pharmacy_project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    // Authentication
    EMPLOYEE_NOT_FOUND(404, "employee not found"),
    UNAUTHENTICATED(400, "unauthenticated"),
    // Customer
    CUSTOMER_NOT_FOUND(404, "customer not found");

    private final int code;
    private final String message;
}
