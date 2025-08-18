package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

import java.util.List;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccountDetails(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}
