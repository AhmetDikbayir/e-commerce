package com.tpe.ecommerce.domain.user;

import com.tpe.ecommerce.domain.business.OrderItem;
import com.tpe.ecommerce.domain.enums.Gender;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastName;


    @Column(nullable = false, unique = true, length = 50)
    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<OrderItem> orders;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
