package domain;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.assertj.core.api.Assertions;
import org.example.domain.ShoppingCartCalculatorService;
import org.example.domain.models.Product;
import org.example.domain.models.ShoppingCart;

import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCartStepDefs {
    ShoppingCart shoppingCart;

    @Given("an individual")
    public void anIndividual() {

    }

    @Given("a big company")
    public void aBigCompany() {

    }

    @Given("a small company")
    public void aSmallCompany() {

    }

    @Given("an empty shopping cart")
    public void anEmptyShoppingCart() {
        shoppingCart = new ShoppingCart(Set.of());
    }

    @Given("a shopping cart containing")
    public void aShoppingCart(DataTable productTable) {
        var products = productTable.asMaps().stream()
                .map(map -> new Product(Integer.parseInt(map.get("id")), map.get("productName"), Integer.parseInt(map.get("quantity"))))
                .collect(Collectors.toSet());
        shoppingCart = new ShoppingCart(products);
    }

    @Given("total price is {float}")
    public void assertTotalPrice(float totalPrice) {
        var calculator = new ShoppingCartCalculatorService();
        Assertions.assertThat(calculator.calculate(shoppingCart)).isEqualTo(totalPrice);
    }
}
