package com.tpe.ecommerce.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "Name cannot be null!")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String name;

    @NotNull(message = "Lastname cannot be null!")
    @NotEmpty(message = "Lastname cannot be empty")
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String lastName;

    @NotNull(message = "Email cannot be null!")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 3, max = 50)
    @Column(nullable = false, unique = true, length = 50)
    @Email(message = "Provide valid email")
    private String email;

    private String phone;

    @OneToMany(mappedBy = "customer")
    private Set<OrderItem> orders;
}
