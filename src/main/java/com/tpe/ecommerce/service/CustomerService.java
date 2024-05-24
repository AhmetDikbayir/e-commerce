package com.tpe.ecommerce.service;

import com.tpe.ecommerce.domain.Customer;
import com.tpe.ecommerce.dto.CustomerDTO;
import com.tpe.ecommerce.mapper.CustomerMapper;
import com.tpe.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOTocustomer(customerDTO);
        customerRepository.save(customer);
    }
}
