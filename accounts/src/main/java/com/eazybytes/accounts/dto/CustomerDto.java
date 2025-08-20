package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 5,max = 30,  message = "Name should have at least 2 characters")
    private String name;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Invalid email format")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid mobile number format")
    private String mobileNumber;
    private AccountsDto accountsDto;
}
