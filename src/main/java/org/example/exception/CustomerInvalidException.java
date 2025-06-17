package org.example.exception;

public class CustomerInvalidException extends Exception {
    public CustomerInvalidException(String invalidCustomerType) {
        super(String.format("Invalid customer type %s", invalidCustomerType));
    }
}
