package com.tpe.ecommerce.payload.request;

import javax.validation.constraints.*;

public class CustomerRequest {
    @NotNull(message = "Name cannot be null!")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Your name should be at least 2 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your username must consist of the characters.")
    private String name;

    @NotNull(message = "Lastname cannot be null!")
    @NotEmpty(message = "Lastname cannot be empty")
    @Size(min = 2, max = 50, message = "Your lastname should be at least 2 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your username must consist of the characters.")
    private String lastName;

    @NotNull(message = "Email cannot be null!")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 3, max = 50)
    @Email(message = "Provide valid email")
    private String email;

    @NotNull(message = "Please enter your phone number")
    @Size(min = 12, max = 12,message = "Your phone number should be 12 characters long")
    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    private String phoneNumber;
}
