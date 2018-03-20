import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualItemTests {
    //not sure if this approach according valid way to render out general data for Unit tests in init() method
    //need your clarification
    String name = "PornHub Premium Account";
    double price = 124;
    double sizeOnDisk = 200000;

    VirtualItem virtualItem;

    @BeforeEach
    void init() {
        virtualItem = new VirtualItem();
        virtualItem.setName(name);
        virtualItem.setPrice(price);
        virtualItem.setSizeOnDisk(sizeOnDisk);
    }

    @Test
    @Tag("virtualItemPositiveTest")
    public void should_CreateVirtualItemAndReturnSizeOnDisk_IfDataValid_Test() {
        assertEquals(sizeOnDisk, virtualItem.getSizeOnDisk(), "Created Virtual item does not return valid size on disk value");
    }

    @Test
    @Tag("virtualItemPositiveTest")
    public void should_ReturnValidStringObjectRepresenting_IfDataValid_Test() {
        String expectedStringRepresenting = String.format("Class: %s; Name: %s; Price: %s; Size on disk: %s", VirtualItem.class.toString(), name, price, sizeOnDisk);

        assertEquals(expectedStringRepresenting, virtualItem.toString(), "Created Virtual item does not return valid string object representing");
    }
}
