package com.iuh.pharmacy_project.dto.request;

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
    String employeeId;
    String customerId;
    boolean isBankTransfer;
    double totalAmount;
    List<InvoiceDetailRequest> details;
}
