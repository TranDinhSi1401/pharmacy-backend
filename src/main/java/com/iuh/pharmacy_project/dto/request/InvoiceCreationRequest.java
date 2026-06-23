package com.iuh.pharmacy_project.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceCreationRequest {
    @NotBlank(message = "Employee ID is required")
    String employeeId;
    @NotBlank(message = "Customer ID is required")
    String customerId;

    boolean isBankTransfer;

    @NotBlank(message = "Total amount is required")
    double totalAmount;

    @NotBlank(message = "Invoice details are required")
    @Valid
    List<InvoiceDetailRequest> details;
}
