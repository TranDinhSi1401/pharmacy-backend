package com.iuh.pharmacy_project.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceDetailRequest {
    String productId;
    String unitId;
    int quantity;
    double price;
}
