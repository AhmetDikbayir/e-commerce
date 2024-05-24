package com.tpe.ecommerce.controller;

import com.tpe.ecommerce.domain.Customer;
import com.tpe.ecommerce.dto.CustomerDTO;
import com.tpe.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping //GetAll Customers
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> customerDTOs = customerService.getAll();
        return ResponseEntity.ok(customerDTOs);
    }

    @GetMapping("/query")
    public ResponseEntity<CustomerDTO> getById(@Valid @RequestParam("id") Long id){
        CustomerDTO customerDTO = customerService.getById(id);
        return ResponseEntity.ok(customerDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam("id") Long id){
        customerService.deleteById(id);
        String message = "Customer was deleted successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") Long id,
                                                      @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(id, customerDTO);
        String message = "Customer was successfully updated";
        return ResponseEntity.ok(message);
    }

}
