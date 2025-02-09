package com.luv2codes.accounts.service;


import com.luv2codes.accounts.dto.CustomerDetailsDto;

public interface CustomersService {

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
