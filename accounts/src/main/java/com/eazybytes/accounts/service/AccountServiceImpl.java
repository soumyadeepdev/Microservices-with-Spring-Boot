package com.eazybytes.accounts.service;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyExistsException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService{


    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());

        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());

        if(existingCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already exist");
        }


        Customer savedCustomer = customerRepository.save(customer);

        Accounts accounts = new Accounts();

        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        accounts.setAccountNumber(randomAccNumber);
        accounts.setAccountType(AccountsConstants.SAVINGS);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);
        accounts.setCustomerId(savedCustomer.getCustomerId());

        Accounts savedAccount = accountsRepository.save(accounts);







    }
}
