package com.creditapplicationsystem.creditapplicationsystem.model.mapper;

import com.creditapplicationsystem.creditapplicationsystem.model.dto.CustomerDTO;
import com.creditapplicationsystem.creditapplicationsystem.model.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setIdentificationNumber(customer.getIdentificationNumber());
        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setPhoneNumber(customer.getPhoneNumber());
        customer.getIdentificationNumber(customer.getIdentificationNumber());
        return customer;
    }
}
