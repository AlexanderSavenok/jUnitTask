import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("cartPositiveTest")
public class CartTests {

    @Test
    public void should_CalculateTotalPrice_IfDataValid_Test() {
        String cartName = "TestCart";
        String itemName = "Car";
        double itemPrice = 45;
        double tax = 0.2;
        double expectedTotalPrice = itemPrice + itemPrice * tax;
        Cart cart = new Cart(cartName);
        RealItem item = new RealItem();
        item.setName(itemName);
        item.setPrice(itemPrice);

        cart.addRealItem(item);
        double totalPrice = cart.getTotalPrice();

        assertAll("Cart",
                () -> assertEquals(expectedTotalPrice, totalPrice, "Calculate total price wrong"),
                () -> assertEquals(cartName, cart.getCartName(), "Cart name is not equals valid value")
        );
    }
}
