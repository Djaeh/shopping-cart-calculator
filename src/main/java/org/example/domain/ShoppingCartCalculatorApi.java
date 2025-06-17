package org.example.domain;

import org.example.domain.models.Customer;
import org.example.domain.models.ShoppingCart;

@FunctionalInterface
public interface ShoppingCartCalculatorApi {

    float calculate(Customer customer, ShoppingCart shoppingCart);
}
