package com.iuh.pharmacy_project.service;

import com.iuh.pharmacy_project.dto.CustomerDto;
import com.iuh.pharmacy_project.entity.Customer;
import com.iuh.pharmacy_project.exception.CustomException;
import com.iuh.pharmacy_project.exception.ErrorCode;
import com.iuh.pharmacy_project.mapper.CustomerMapper;
import com.iuh.pharmacy_project.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class CustomerService {
    final CustomerRepository customerRepository;
    final CustomerMapper customerMapper;

    public CustomerDto getCustomerByPhone(String phone) {
        Optional<Customer> optional = customerRepository.findByPhone(phone);

        Customer customer = optional.orElseThrow(() ->
                new CustomException(ErrorCode.CUSTOMER_NOT_FOUND)
        );

        return customerMapper.toDto(customer);
    }
}
