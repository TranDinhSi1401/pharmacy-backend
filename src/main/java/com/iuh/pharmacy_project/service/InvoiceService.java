package com.iuh.pharmacy_project.service;

import com.iuh.pharmacy_project.dto.InvoiceDto;
import com.iuh.pharmacy_project.entity.Customer;
import com.iuh.pharmacy_project.entity.Invoice;
import com.iuh.pharmacy_project.exception.CustomException;
import com.iuh.pharmacy_project.exception.ErrorCode;
import com.iuh.pharmacy_project.mapper.InvoiceMapper;
import com.iuh.pharmacy_project.repository.CustomerRepository;
import com.iuh.pharmacy_project.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class InvoiceService {
    final InvoiceRepository invoiceRepository;
    final CustomerRepository customerRepository;
    final MongoTemplate mongoTemplate;
    final InvoiceMapper invoiceMapper;

    public List<InvoiceDto> getInvoices(LocalDate startDate, LocalDate endDate,
                                        String employeeId, String phone) {
        Query query = new Query();

        if (startDate != null && endDate != null) {
            query.addCriteria(Criteria.where("createdDate")
                    .gte(startDate.atStartOfDay())
                    .lte(endDate.atTime(23, 59, 59)));
        }

        if (employeeId != null && !employeeId.isBlank()) {
            query.addCriteria(Criteria.where("employeeId").is(employeeId));
        }

        if (phone != null && !phone.isBlank()) {
            // Tìm customerId từ phone
            Customer customer = customerRepository.findByPhone(phone)
                    .orElseThrow(() -> new CustomException(ErrorCode.CUSTOMER_NOT_FOUND));
            query.addCriteria(Criteria.where("customerId").is(customer.getId()));
        }

        return mongoTemplate.find(query, Invoice.class).stream()
                .map(invoiceMapper::toDto)
                .collect(java.util.stream.Collectors.toList());
    }
}
