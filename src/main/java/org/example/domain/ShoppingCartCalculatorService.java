package org.example.domain;

import org.example.domain.models.Customer;
import org.example.domain.models.CustomerType;
import org.example.domain.models.ShoppingCart;

import java.util.Map;

import static org.example.domain.models.CustomerType.*;

public class ShoppingCartCalculatorService implements ShoppingCartCalculatorApi {

    private final Map<CustomerType, Map<Integer, Float>> priceMap = Map.of(
            INDIVIDUAL, Map.of(1, 1500f, 2, 800f, 3, 1200f),
            SMALL_COMPANY, Map.of(1, 1150f, 2, 600f, 3, 1000f),
            BIG_COMPANY, Map.of(1, 1000f, 2, 550f, 3, 900f)
            );

    @Override
    public float calculate(Customer customer, ShoppingCart shoppingCart) {
        return shoppingCart.products()
                .stream()
                .map(product -> product.quantity()*priceMap.get(customer.type()).get(product.id()))
                .reduce(Float::sum)
                .orElse(0f);
    }
}
