package com.tpe.ecommerce.service.user;

import com.tpe.ecommerce.entity.user.User;
import com.tpe.ecommerce.exceptions.ConflictException;
import com.tpe.ecommerce.exceptions.ResourceNotFoundException;
import com.tpe.ecommerce.payload.mapper.user.UserMapper;
import com.tpe.ecommerce.payload.request.user.UserRequest;
import com.tpe.ecommerce.payload.response.user.UserResponse;
import com.tpe.ecommerce.repository.business.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CustomerRepository customerRepository;
    private UserMapper customerMapper;
    public void saveUser(UserRequest customerRequest) {
        //TODO: Kontroller yapılacak
        User customer = customerMapper.customerRequestToCustomer(customerRequest);
        customerRepository.save(customer);
    }

    public User findById(Long id){
        User customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found: " + id));
        return customer;
    }
    public UserResponse getById(Long id) {
        User customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found: " + id));
        UserResponse customerResponse = customerMapper.customerToCustomerResponse(customer);
        return customerResponse;
    }

    public List<UserResponse> getAll() {
        List<User> customers =  customerRepository.findAll();
        List<UserResponse> customerDTOS = customers.stream()
                .map(customerMapper::customerToCustomerResponse)
                .collect(Collectors.toList());
        return customerDTOS;
    }

    public void deleteById(Long id) {
        UserResponse customerResponse = getById(id);
        customerRepository.deleteById(id);

    }


    public UserResponse updateCustomer(Long id, UserRequest customerRequest) {
        User updatedCustomer = findById(id);
        Boolean isEmailExist = customerRepository.existsByEmail(customerRequest.getEmail());
        if(isEmailExist && updatedCustomer.getEmail().equals(customerRequest.getEmail())){
            throw new ConflictException("Email is already exists");
        }
        updatedCustomer.setEmail(customerRequest.getEmail());
        updatedCustomer.setName(customerRequest.getName());
        updatedCustomer.setLastName(customerRequest.getLastName());
        updatedCustomer.setPhoneNumber(customerRequest.getPhoneNumber());
        customerRepository.save(updatedCustomer);

        return customerMapper.customerToCustomerResponse(updatedCustomer);
    }
}
