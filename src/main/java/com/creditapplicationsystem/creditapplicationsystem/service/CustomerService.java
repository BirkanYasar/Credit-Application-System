package com.creditapplicationsystem.creditapplicationsystem.service;

import com.creditapplicationsystem.creditapplicationsystem.model.entity.Customer;
import com.creditapplicationsystem.creditapplicationsystem.model.dto.CustomerDTO;
import com.creditapplicationsystem.creditapplicationsystem.model.mapper.CustomerMapper;
import com.creditapplicationsystem.creditapplicationsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return allCustomers;
    }

    public Customer getByIdentificationNumber(Long identificationNumber) {
        Optional<Customer> byId = customerRepository.findById(identificationNumber);
        return byId.orElseThrow(() -> {
            log.error("Customer not found by id : " + getByIdentificationNumber());
            return new EntityNotFoundException("Customer", "identification : " + getByIdentificationNumber());
        });
    }

    public Customer getByName(String name) {
        Optional<Customer> byId = customerRepository.findByName(name);
        return byId.orElseThrow(() -> {
            log.error("Customer not found by name : " + getByName());
            return new EntityNotFoundException("Customer", "identification : " + getByIdentificationNumber());
        });
    }

    public Customer create(CustomerDTO courseDTO) {
        Customer customer = CustomerMapper.toEntity(courseDTO);
        return customerRepository.save(customer);
    }

    public void delete(Long identificationNumber) {
        getByIdentificationNumber(identificationNumber);
        customerRepository.deleteById(identificationNumber);
    }

}
