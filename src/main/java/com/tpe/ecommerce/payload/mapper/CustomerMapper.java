package com.tpe.ecommerce.payload.mapper;

import com.tpe.ecommerce.entity.user.Customer;
import com.tpe.ecommerce.dto.CustomerDTO;
import com.tpe.ecommerce.payload.request.CustomerRequest;
import com.tpe.ecommerce.payload.response.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    public Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .build();
    }

}
