package com.tpe.ecommerce.payload.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserResponse {
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
}
