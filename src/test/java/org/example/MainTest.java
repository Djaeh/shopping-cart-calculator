package org.example;

import junit.framework.TestCase;
import org.example.exception.CustomerInvalidException;
import org.example.exception.ShoppingCartInvalidException;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MainTest extends TestCase {

    public void testShouldCalculateCartPrice() {
        var args = new String[]{"INDIVIDUAL", "1,High quality smartphone,2", "2,Middle quality smartphone,1", "3,laptop,3"};
        assertThatCode(
                () -> Main.main(args)
        ).doesNotThrowAnyException();
    }

    public void testShouldThrowWhenInvalidCustomerType() {
        var args = new String[]{"UNKNOWN", "1,High quality smartphone,2", "2,Middle quality smartphone,1", "3,laptop,3"};
        assertThatCode(
                () -> Main.main(args)
        ).isInstanceOf(CustomerInvalidException.class)
                .hasMessage("Invalid customer type UNKNOWN");
    }

    public void testShouldThrowWhenInvalidProduct() {
        var args = new String[]{"INDIVIDUAL", "1,High quality smartphone,b", "2,Middle quality smartphone,1", "laptop,3"};
        assertThatCode(
                () -> Main.main(args)
        ).isInstanceOf(ShoppingCartInvalidException.class)
                .hasMessageContaining("1,High quality smartphone,b")
                .hasMessageContaining("laptop,3");
    }
}