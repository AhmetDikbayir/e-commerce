package com.tpe.ecommerce.service.business;

import com.tpe.ecommerce.entity.user.Customer;
import com.tpe.ecommerce.exceptions.ConflictException;
import com.tpe.ecommerce.exceptions.ResourceNotFoundException;
import com.tpe.ecommerce.payload.mapper.CustomerMapper;
import com.tpe.ecommerce.payload.request.CustomerRequest;
import com.tpe.ecommerce.payload.response.CustomerResponse;
import com.tpe.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    public void saveCustomer(CustomerRequest customerRequest) {
        Customer customer = customerMapper.customerRequestToCustomer(customerRequest);
        customerRepository.save(customer);
    }

    public Customer findById(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found: " + id));
        return customer;
    }
    public CustomerResponse getById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found: " + id));
        CustomerResponse customerResponse = customerMapper.customerToCustomerResponse(customer);
        return customerResponse;
    }

    public List<CustomerResponse> getAll() {
        List<Customer> customers =  customerRepository.findAll();
        List<CustomerResponse> customerDTOS = customers.stream()
                .map(customerMapper::customerToCustomerResponse)
                .collect(Collectors.toList());
        return customerDTOS;
    }

    public void deleteById(Long id) {
        CustomerResponse customerResponse = getById(id);
        customerRepository.deleteById(id);

    }


    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer updatedCustomer = findById(id);
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
