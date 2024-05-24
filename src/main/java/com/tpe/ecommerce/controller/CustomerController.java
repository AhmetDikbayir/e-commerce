package com.tpe.ecommerce.controller;

import com.tpe.ecommerce.domain.Customer;
import com.tpe.ecommerce.dto.CustomerDTO;
import com.tpe.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>("Ok", HttpStatus.CREATED);

    }



    @GetMapping
    public ResponseEntity<String> getAllCustomers(){
        String message = "Everything is fine";
        return ResponseEntity.ok(message);
    }
}
