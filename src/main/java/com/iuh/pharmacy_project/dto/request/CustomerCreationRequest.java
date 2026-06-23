package com.iuh.pharmacy_project.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerCreationRequest {
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Last name must not contain special characters")
    String lastName;

    @Pattern(regexp = "^[\\p{L} ]+$", message = "Last name must not contain special characters")
    String firstName;

    @Pattern(regexp = "^\\d{10}$",message = "Phone number must be exactly 10 digits")
    String phone;
}
