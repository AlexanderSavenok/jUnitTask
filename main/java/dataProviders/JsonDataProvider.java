package dataProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import shop.Cart;

import java.util.stream.Stream;

public class JsonDataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Cart firstCart = null;
        Cart secondCart = null;
        Cart thirdCart = null;
        Cart fourthCart = null;
        Cart fifthCart = null;

        return Stream.of(
                Arguments.of(firstCart), Arguments.of(secondCart), Arguments.of(thirdCart), Arguments.of(fourthCart),
                Arguments.of(fifthCart)
        );
    }
}
