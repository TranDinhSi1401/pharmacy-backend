package com.iuh.pharmacy_project.mapper;

import com.iuh.pharmacy_project.dto.EmployeeDto;
import com.iuh.pharmacy_project.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);
}
