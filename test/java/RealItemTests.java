import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealItemTests {
    //not sure if this approach according valid way to render out general data for Unit tests in init() method
    //need your clarification

    String name = "BMW";
    double price = 54242.4;
    double weight = 2000;

    RealItem realItem;

    @BeforeEach
    void init() {
        realItem = new RealItem();
        realItem.setName(name);
        realItem.setPrice(price);
        realItem.setWeight(weight);
    }

    @Test
    @Tag("realItemPositiveTest")
    public void should_CreateRealItemAndReturnWeight_IfDataValid_Test() {
        assertEquals(weight, realItem.getWeight(), "Created Real item does not return valid weight value");
    }

    @Test
    @Tag("realItemPositiveTest")
    public void should_ReturnValidStringObjectRepresenting_IfDataValid_Test() {
        String expectedStringRepresenting = String.format("Class: %s; Name: %s; Price: %s; Weight: %s", RealItem.class.toString(), name, price, weight);

        assertEquals(expectedStringRepresenting, realItem.toString(), "Created Real item does not return valid string object representing");
    }
}
