package domain;

import io.cucumber.java.en.Given;
import org.assertj.core.api.Assertions;
import org.example.domain.ShoppingCartCalculatorService;

public class ShoppingCartStepDefs {

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

    }

    @Given("total price is {float}")
    public void assertTotalPrice(float totalPrice) {
        var calculator = new ShoppingCartCalculatorService();
        Assertions.assertThat(calculator.calculate()).isEqualTo(totalPrice);
    }
}
