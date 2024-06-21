package com.tpe.ecommerce.controller;

import com.tpe.ecommerce.payload.messages.ErrorMessages;
import com.tpe.ecommerce.payload.messages.SuccessMessages;
import com.tpe.ecommerce.payload.request.CustomerRequest;
import com.tpe.ecommerce.payload.response.CustomerResponse;
import com.tpe.ecommerce.service.business.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        customerService.saveCustomer(customerRequest);
        return new ResponseEntity<>("Ok", HttpStatus.CREATED);
    }

    @GetMapping //GetAll Customers
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/query")
    public ResponseEntity<CustomerResponse> getById(@Valid @RequestParam("id") Long id){
        CustomerResponse customerResponse = customerService.getById(id);
        return ResponseEntity.ok(customerResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam("id") Long id){
        customerService.deleteById(id);
        String message = "Customer was deleted successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("id") Long id,
                                                      @RequestBody @Valid CustomerRequest customerRequest){
        return new ResponseEntity<>(customerService.updateCustomer(id, customerRequest), HttpStatus.OK);
    }

}
