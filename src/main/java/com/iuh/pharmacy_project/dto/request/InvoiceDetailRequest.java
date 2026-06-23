package com.iuh.pharmacy_project.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceDetailRequest {
    @NotBlank(message = "Product ID is required")
    String productId;

    @NotBlank(message = "Unit ID is required")
    String unitId;

    @NotBlank(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    int quantity;

    @NotBlank(message = "Price is required")
    @Min(value = 0, message = "Price must be a positive number")
    double price;
}
