package com.tpe.ecommerce.entity.user;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

    @NotNull(message = "Street name cannot be null.")
    private String street;
    @NotNull(message = "City name cannot be null.")
    private String city;

    @NotNull(message = "Country name cannot be null.")
    private String country;

    @NotNull(message = "Zipcode name cannot be null.")
    private int zipcode;
}
