package domain;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.example.domain.ShoppingCartCalculatorService;
import org.example.domain.models.Customer;
import org.example.domain.models.CustomerType;
import org.example.domain.models.Product;
import org.example.domain.models.ShoppingCart;

import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCartStepDefs {
    ShoppingCart shoppingCart;
    Customer customer;
    float calculatedTotalPrice;

    @Given("an individual")
    public void anIndividual() {
        customer = new Customer(CustomerType.INDIVIDUAL);
    }

    @Given("a big company")
    public void aBigCompany() {
        customer = new Customer(CustomerType.BIG_COMPANY);
    }

    @Given("a small company")
    public void aSmallCompany() {
        customer = new Customer(CustomerType.SMALL_COMPANY);
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

    @When("calculation is done")
    public void calculate() {
        var calculator = new ShoppingCartCalculatorService();
        calculatedTotalPrice = calculator.calculate(customer, shoppingCart);
    }

    @Then("total price is {float}")
    public void assertTotalPrice(float totalPrice) {
        Assertions.assertThat(calculatedTotalPrice).isEqualTo(totalPrice);
    }
}
