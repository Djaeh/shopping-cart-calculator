package org.example.exception;

import java.util.Set;

public class ShoppingCartInvalidException extends Exception {
    public ShoppingCartInvalidException(Set<String> invalidProducts) {
        super(String.format("Invalid products: %s", String.join(" | ", invalidProducts)));
    }
}
