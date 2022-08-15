package com.creditapplicationsystem.creditapplicationsystem.controller;

import com.creditapplicationsystem.creditapplicationsystem.model.dto.CustomerDTO;
import com.creditapplicationsystem.creditapplicationsystem.model.entity.Customer;
import com.creditapplicationsystem.creditapplicationsystem.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/welcome")
    private String loginScreen() {
        return "Welcome!/n Create a customer profile right now " +
                "to see the privileged loan offers our bank has prepared for our customers!";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity createNewCustomer(@RequestBody CustomerDTO customer) {
        Customer respCustomer = customerService.create(customer);
        if (respCustomer == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Customer informations could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respCustomer);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @GetMapping("/all")
    public ResponseEntity getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity getCoursesById(@PathVariable("id") Long id) {
        Customer byId = customerService.getByIdentificationNumber();
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

}
