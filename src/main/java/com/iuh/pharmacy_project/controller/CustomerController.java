package com.iuh.pharmacy_project.controller;

import com.iuh.pharmacy_project.dto.ApiResponse;
import com.iuh.pharmacy_project.dto.CustomerDto;
import com.iuh.pharmacy_project.dto.request.CustomerCreationRequest;
import com.iuh.pharmacy_project.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/search")
    public ApiResponse<CustomerDto> getCustomerByPhone(@RequestParam String phone) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        ApiResponse<CustomerDto> response = new ApiResponse<>();
        response.setResult(customerService.getCustomerByPhone(phone));
        response.setMessage("Fetched customer successfully");
        return response;
    }

    @PostMapping
    public ApiResponse<CustomerDto> createCustomer(@RequestBody @Valid CustomerCreationRequest request) {
        ApiResponse<CustomerDto> response = new ApiResponse<>();
        response.setCode(201);
        response.setResult(customerService.createCustomer(request));
        response.setMessage("Created customer successfully");
        return response;
    }
}
