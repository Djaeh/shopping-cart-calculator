package org.example;

import org.example.domain.ShoppingCartCalculatorService;
import org.example.domain.models.Customer;
import org.example.domain.models.CustomerType;
import org.example.domain.models.Product;
import org.example.domain.models.ShoppingCart;
import org.example.exception.CustomerInvalidException;
import org.example.exception.ShoppingCartInvalidException;

import java.util.HashSet;
import java.util.Set;


public class Main {
    /**
     *
     * @param args: arg[0] should contains customer type [INDIVIDUAL | SMALL_COMPANY | BIG_COMPANY]
     *            arg[n] with n>1 should contains products for the cart as string in this format id,productName,quantity
     *            example: INDIVIDUAL 1,"High quality smartphone",2 2,"Middle quality smartphone",1 3,"laptop",3
     *            Any deviation from this will cause an exception
     */
    public static void main(String[] args) throws CustomerInvalidException, ShoppingCartInvalidException {

        CustomerType type;
        try{
            type = CustomerType.valueOf(args[0]);
        } catch (IllegalArgumentException _) {
            throw new CustomerInvalidException(args[0]);
        }

        Set<String> invalidProducts = new HashSet<>();
        Set<Product> products= new HashSet<>();
        for(int i=1; i<args.length; i++) {
            try {
                var productString = args[i].split(",");
                products.add(new Product(Integer.parseInt(productString[0]), productString[1], Integer.parseInt(productString[2]) ));
            } catch (Exception _) {
                invalidProducts.add(args[i]);
            }

        }
        if(!invalidProducts.isEmpty()) throw new ShoppingCartInvalidException(invalidProducts);

        var calculator = new ShoppingCartCalculatorService();
        System.out.println(calculator.calculate(new Customer(type), new ShoppingCart(products)));
    }
}