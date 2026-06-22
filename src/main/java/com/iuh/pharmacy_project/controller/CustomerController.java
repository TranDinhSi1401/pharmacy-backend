package com.iuh.pharmacy_project.controller;

import com.iuh.pharmacy_project.dto.ApiResponse;
import com.iuh.pharmacy_project.dto.CustomerDto;
import com.iuh.pharmacy_project.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{phone}")
    public ApiResponse<CustomerDto> getCustomerByPhone(@PathVariable String phone) {
        ApiResponse<CustomerDto> response = new ApiResponse<>();
        response.setResult(customerService.getCustomerByPhone(phone));
        response.setMessage("success");
        return response;
    }
}
