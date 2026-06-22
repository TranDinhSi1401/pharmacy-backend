package com.iuh.pharmacy_project.dto;

import com.iuh.pharmacy_project.entity.InvoiceDetail;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class InvoiceCreationRequest {
    private String employeeId;
    private String customerId;
    private LocalDateTime createdDate;
    private boolean isBankTransfer;
    private double totalAmount;
    private List<InvoiceDetail> details;
}
