package com.tpe.ecommerce.service;

import com.tpe.ecommerce.domain.Customer;
import com.tpe.ecommerce.dto.CustomerDTO;
import com.tpe.ecommerce.exceptions.ConflictException;
import com.tpe.ecommerce.exceptions.ResourceNotFoundException;
import com.tpe.ecommerce.payload.mapper.CustomerMapper;
import com.tpe.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public Customer findById(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found: " + id));
        return customer;
    }
    public CustomerDTO getById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found: " + id));
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
        return customerDTO;
    }

    public List<CustomerDTO> getAll() {
        List<Customer> customers =  customerRepository.findAll();
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
        return customerDTOS;
    }

    public void deleteById(Long id) {
        CustomerDTO customerDTO = getById(id);
        customerRepository.deleteById(id);

    }


    public void updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer updatedCustomer = findById(id);
        Boolean isEmailExist = customerRepository.existsByEmail(customerDTO.getEmail());
        if(isEmailExist && updatedCustomer.getEmail().equals(customerDTO.getEmail())){
            throw new ConflictException("Email is already exists");
        }
        updatedCustomer.setEmail(customerDTO.getEmail());
        updatedCustomer.setName(customerDTO.getName());
        updatedCustomer.setLastName(customerDTO.getLastName());
        updatedCustomer.setPhone(customerDTO.getPhone());
        customerRepository.save(updatedCustomer);



    }
}
