package assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class CartAssert extends AbstractAssert<CartAssert, Response> {

    public CartAssert(Response actual) {
        super(actual, CartAssert.class);
    }

    public static CartAssert assertThat(Response actual) {
        return new CartAssert(actual);
    }

    @Step("Проверить содержимого корзины")
    public CartAssert checkCartResponse(int id, String name, String category, Float price, Float discount,
                                        int quantity) {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqual(200)
                .responseFieldIsEqual("cart[0].id", id)
                .responseFieldIsEqual("cart[0].name", name)
                .responseFieldIsEqual("cart[0].category", category)
                .responseFieldIsEqual("cart[0].price", price)
                .responseFieldIsEqual("cart[0].discount", discount)
                .responseFieldIsEqual("cart[0].quantity", quantity);

        return this;
    }

    @Step("Проверить, что корзина пуста")
    public CartAssert checkCartIsEmpty() {
        BasicAssert.assertThat(actual).responseIsEmpty("cart[0]");
        return this;
    }
}
