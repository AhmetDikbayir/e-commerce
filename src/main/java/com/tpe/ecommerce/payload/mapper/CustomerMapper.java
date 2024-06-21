package com.tpe.ecommerce.payload.mapper;

import com.tpe.ecommerce.domain.user.Customer;
import com.tpe.ecommerce.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO customerToCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    public Customer customerDTOTocustomer(CustomerDTO customerDTO){
        return Customer.builder()
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .build();
    }

}
