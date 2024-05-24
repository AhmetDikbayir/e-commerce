package com.tpe.ecommerce.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDTO {

    @NotNull(message = "Name cannot be null!")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 50)
    private String name;

    @NotNull(message = "Lastname cannot be null!")
    @NotEmpty(message = "Lastname cannot be empty")
    @Size(min = 2, max = 50)
    private String lastName;

    @NotNull(message = "Email cannot be null!")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 3, max = 50)
    @Email(message = "Provide valid email")
    private String email;

    private String phone;
}
