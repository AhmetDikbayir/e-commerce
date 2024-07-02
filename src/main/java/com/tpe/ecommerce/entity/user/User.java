package com.tpe.ecommerce.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tpe.ecommerce.entity.business.Cart;
import com.tpe.ecommerce.entity.business.Order;
import com.tpe.ecommerce.entity.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_user")
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

    @Column(unique = true)
    private String ssn;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 12)
    private String phoneNumber;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

//    @OneToOne
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private UserRole userRole;

}
