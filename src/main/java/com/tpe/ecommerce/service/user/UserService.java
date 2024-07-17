package com.tpe.ecommerce.service.user;

import com.tpe.ecommerce.entity.user.User;
import com.tpe.ecommerce.exceptions.ConflictException;
import com.tpe.ecommerce.exceptions.ResourceNotFoundException;
import com.tpe.ecommerce.payload.mapper.user.UserMapper;
import com.tpe.ecommerce.payload.request.user.UserRequest;
import com.tpe.ecommerce.payload.response.user.UserResponse;
import com.tpe.ecommerce.repository.user.UserRepository;
import com.tpe.ecommerce.service.helper.MethodHelper;
import com.tpe.ecommerce.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PageableHelper pageableHelper;
    private final UserMapper userMapper;

    private UserMapper customerMapper;
    public void saveUser(UserRequest customerRequest) {
        //TODO: Kontroller yapılacak
        User customer = customerMapper.customerRequestToCustomer(customerRequest);
        userRepository.save(customer);
    }

    public User findById(Long id){
        User customer = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found: " + id));
        return customer;
    }
    public UserResponse getById(Long id) {
        User customer = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found: " + id));
        UserResponse customerResponse = customerMapper.customerToCustomerResponse(customer);
        return customerResponse;
    }

    public List<UserResponse> getAll() {
        List<User> customers =  userRepository.findAll();
        List<UserResponse> customerDTOS = customers.stream()
                .map(customerMapper::customerToCustomerResponse)
                .collect(Collectors.toList());
        return customerDTOS;
    }

    public void deleteById(Long id) {
        UserResponse customerResponse = getById(id);
        userRepository.deleteById(id);

    }


    public UserResponse updateCustomer(Long id, UserRequest customerRequest) {
        User updatedCustomer = findById(id);
        Boolean isEmailExist = userRepository.existsByEmail(customerRequest.getEmail());
        if(isEmailExist && updatedCustomer.getEmail().equals(customerRequest.getEmail())){
            throw new ConflictException("Email is already exists");
        }
        updatedCustomer.setEmail(customerRequest.getEmail());
        updatedCustomer.setName(customerRequest.getName());
        updatedCustomer.setLastName(customerRequest.getLastName());
        updatedCustomer.setPhoneNumber(customerRequest.getPhoneNumber());
        userRepository.save(updatedCustomer);

        return customerMapper.customerToCustomerResponse(updatedCustomer);
    }
    public List<UserResponse> getAllUserByFullName(String name, String lastName) {
        List<User> foundUserList = userRepository.findByUserFullName(name, lastName);
        List<UserResponse> foundUserResponseList = new ArrayList<>();
        for(User foundUser : foundUserList){
            UserResponse foundUserResponse = customerMapper.customerToCustomerResponse(foundUser);
            foundUserResponseList.add(foundUserResponse);
        }
        return foundUserResponseList;
    }

    public List<UserResponse> getAllUsersByContainsName(String name) {
        List<User> foundUsersList = userRepository.getAllUsersByContainsName(name);
        List<UserResponse> foundUserResponseList = new ArrayList<>();
        for(User foundUser : foundUsersList){
            UserResponse foundUserResponse = customerMapper.customerToCustomerResponse(foundUser);
            foundUserResponseList.add(foundUserResponse);
        }
        return foundUserResponseList;

    }

    public ResponseEntity<Page<UserResponse>> getAllCustomersByPage(int page, int size, String sort, String type) {
        Pageable pageable = pageableHelper.getPageableWithProperties(page, size, sort, type);

        return ResponseEntity.ok(userRepository.findAll(pageable).map(userMapper::customerToCustomerResponse));
    }
}
