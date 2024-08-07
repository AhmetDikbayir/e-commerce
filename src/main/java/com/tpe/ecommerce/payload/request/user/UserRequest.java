package com.tpe.ecommerce.payload.request.user;

import com.tpe.ecommerce.entity.user.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserRequest {

    //!!!! User Request User a göre güncellenecek!!!!


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

    @NotNull
    @Pattern(regexp = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$",
            message = "Please enter valid SSN number")
    private String ssn;

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

    private Address address;
}
