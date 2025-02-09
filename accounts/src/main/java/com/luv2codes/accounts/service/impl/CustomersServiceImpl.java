package com.luv2codes.accounts.service.impl;

import com.luv2codes.accounts.dto.AccountsDto;
import com.luv2codes.accounts.dto.CardsDto;
import com.luv2codes.accounts.dto.CustomerDetailsDto;
import com.luv2codes.accounts.dto.LoansDto;
import com.luv2codes.accounts.entity.Accounts;
import com.luv2codes.accounts.entity.Customer;
import com.luv2codes.accounts.exception.ResourceNotFoundException;
import com.luv2codes.accounts.mapper.AccountsMapper;
import com.luv2codes.accounts.mapper.CustomerMapper;
import com.luv2codes.accounts.repository.AccountsRepository;
import com.luv2codes.accounts.repository.CustomerRepository;
import com.luv2codes.accounts.service.CustomersService;
import com.luv2codes.accounts.service.client.CardsFeinClient;
import com.luv2codes.accounts.service.client.LoansFeinClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements CustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeinClient cardsFeinClient;
    private LoansFeinClient loansFeinClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public com.luv2codes.accounts.dto.CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeinClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeinClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
