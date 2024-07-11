package com.tpe.ecommerce.controller.user;

import com.tpe.ecommerce.payload.request.user.UserRequest;
import com.tpe.ecommerce.payload.response.user.UserResponse;
import com.tpe.ecommerce.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/save") //http://localhost:8080/customers/save
    public ResponseEntity<String> saveUser(@RequestBody @Valid UserRequest customerRequest){
        userService.saveUser(customerRequest);
        return new ResponseEntity<>("Ok", HttpStatus.CREATED);
    }

    @GetMapping //http://localhost:8080/customers
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/query") //http://localhost:8080/customers/query
    public ResponseEntity<UserResponse> getById(@Valid @RequestParam("id") Long id){
        UserResponse customerResponse = userService.getById(id);
        return ResponseEntity.ok(customerResponse);
    }

    @DeleteMapping("/delete") //http://localhost:8080/customers/delete?id=2
    public ResponseEntity<String> deleteCustomer(@RequestParam("id") Long id){
        userService.deleteById(id);
        String message = "Customer was deleted successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update/{id}") //http://localhost:8080/customers/update/3
    public ResponseEntity<UserResponse> updateCustomer(@PathVariable("id") Long id,
                                                       @RequestBody @Valid UserRequest customerRequest){
        return new ResponseEntity<>(userService.updateCustomer(id, customerRequest), HttpStatus.OK);
    }

    @GetMapping("/fullquery")
    public ResponseEntity<List<UserResponse>> getAllUserByFullName(@RequestParam("name") String name, @RequestParam("lastName") String lastName){
        return ResponseEntity.ok(userService.getAllUserByFullName(name, lastName));
    }



}
