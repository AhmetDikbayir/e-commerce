package com.tpe.ecommerce.payload.mapper.user;

import com.tpe.ecommerce.entity.user.User;
import com.tpe.ecommerce.payload.request.user.UserRequest;
import com.tpe.ecommerce.payload.response.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse customerToCustomerResponse(User customer) {
        return UserResponse.builder()
                .name(customer.getName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    public User customerRequestToCustomer(UserRequest customerRequest){
        return User.builder()
                .name(customerRequest.getName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .build();
    }

}
