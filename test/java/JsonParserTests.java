import dataProviders.JsonDataProvider;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import parser.JsonParser;
import parser.Parser;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTests {

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    @Tag("jsonParserExceptionTest")
    @DisplayName("Should pass a null object to this test method")
    @ParameterizedTest(name = "{index} => Cart Object=''{0}''")
    @ArgumentsSource(JsonDataProvider.class)
    public void should_handleNullPointerException_IfCartIsNull_Test(Cart cart) {
        Parser parser = new JsonParser();

        assertThrows(java.lang.NullPointerException.class, () -> {parser.writeToFile(cart);});
    }

    @Tag("jsonParserPositiveTest")
    @Test
    @Disabled
    public void should_createJsonFile_IfDataValid_Test() {
        String fileName = "TestFileName_" + timeStamp;
        String filePath = "src/main/resources/" + fileName + ".json";
        File file = new File(filePath);
        Cart cart = new Cart(fileName);
        RealItem car = new RealItem();
        car.setName("Jeely Atlas");
        car.setPrice(26000);
        car.setWeight(2000);
        cart.addRealItem(car);

        try {
            Parser parser = new JsonParser();
            parser.writeToFile(cart);

            assertTrue(file.exists(), "Json file was not created");
        }
        finally {
            file.delete();
        }
    }

    @Tag("jsonParserPositiveTest")
    @Test
    public void should_ParseDataFromFile_IfFileExists_Test() {
        String fileName = "TestFileName_ReadMethod";
        String filePath = String.format("src/main/resources/%s" + ".json", fileName);
        String expectedCartName = "TestFileName_Cart";
        double expectedTotalPrice = 31200.0;

        Parser parser = new JsonParser();
        Cart dataFromFile = parser.readFromFile(new File(filePath));

        assertAll("Cart",
                () -> assertEquals(expectedTotalPrice, dataFromFile.getTotalPrice(), "Total price from json file is invalid"),
                () -> assertEquals(expectedCartName, dataFromFile.getCartName(), "Cart name from json file is invalid")
        );
    }
}
