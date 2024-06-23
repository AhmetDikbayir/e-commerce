package com.tpe.ecommerce.entity.user;

import com.tpe.ecommerce.entity.business.OrderItem;
import com.tpe.ecommerce.entity.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 12)
    private String phoneNumber;

    private Address address;

    @OneToMany(mappedBy = "customer")
    private Set<OrderItem> orders;


}
