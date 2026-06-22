package com.iuh.pharmacy_project.service;

import com.iuh.pharmacy_project.dto.request.AuthenticationRequest;
import com.iuh.pharmacy_project.dto.response.AuthenticationResponse;
import com.iuh.pharmacy_project.entity.Employee;
import com.iuh.pharmacy_project.exception.CustomException;
import com.iuh.pharmacy_project.exception.ErrorCode;
import com.iuh.pharmacy_project.repository.EmployeeRepository;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class AuthenticationService {
    final EmployeeRepository employeeRepository;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Employee  employee = employeeRepository.findById(request.getEmployeeId().trim()).orElseThrow(() ->
                new CustomException(ErrorCode.EMPLOYEE_NOT_FOUND)
        );
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), employee.getAccount().getPasswordHash());

        if(!authenticated) {
            throw new CustomException(ErrorCode.INVALID_PASSWORD);
        }


        return AuthenticationResponse.builder()
                .authenticated(true)
                .build();
    }

    private String generateToken(String employeeId) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(employeeId)
                .issuer("duocankhang.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("customClaim", "Custom")
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        //jwsObject.sign(new MACSigner());
        return null;
    }
}
