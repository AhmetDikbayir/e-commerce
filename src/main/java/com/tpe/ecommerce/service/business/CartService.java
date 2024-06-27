package com.tpe.ecommerce.service.business;


import com.tpe.ecommerce.repository.business.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
}
