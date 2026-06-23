package com.iuh.pharmacy_project.controller;

import com.iuh.pharmacy_project.dto.ApiResponse;
import com.iuh.pharmacy_project.dto.InvoiceDto;
import com.iuh.pharmacy_project.dto.request.InvoiceCreationRequest;
import com.iuh.pharmacy_project.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    final InvoiceService invoiceService;

    @GetMapping
    public ApiResponse<List<InvoiceDto>> getInvoices(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(required = false) String employeeId,
            @RequestParam(required = false) String phone) {

        ApiResponse<List<InvoiceDto>> response = new ApiResponse<>();
        response.setResult(invoiceService.getInvoices(startDate, endDate, employeeId, phone));
        response.setMessage("Fetched Invoices successfully");
        return response;
    }

    @PostMapping
    public ApiResponse<InvoiceDto> createInvoice(@RequestBody InvoiceCreationRequest request) {
        ApiResponse<InvoiceDto> response = new ApiResponse<>();
        response.setResult(invoiceService.createInvoice(request));
        response.setMessage("Invoice created successfully");
        return response;
    }
}
