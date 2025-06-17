package org.example.domain;

import org.example.domain.models.ShoppingCart;

import java.util.Map;

public class ShoppingCartCalculatorService implements ShoppingCartCalculatorApi {

    private final Map<Integer, Float> priceMap = Map.of(1, 1500f, 2, 800f, 3, 1200f);

    @Override
    public float calculate(ShoppingCart shoppingCart) {
        return shoppingCart.products()
                .stream()
                .map(product -> product.quantity()*priceMap.get(product.id()))
                .reduce(Float::sum)
                .orElse(0f);
    }
}
