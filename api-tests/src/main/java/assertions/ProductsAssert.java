package assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class ProductsAssert extends AbstractAssert<ProductsAssert, Response> {

    public ProductsAssert(Response actual) {
        super(actual, ProductsAssert.class);
    }

    public static ProductsAssert assertThat(Response actual) {
        return new ProductsAssert(actual);
    }

    @Step("Проверить товара")
    public ProductsAssert checkProductResponse(int id, String name, String category, Float price, float discount) {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqual(200)
                .responseFieldIsEqual("[0].id", id)
                .responseFieldIsEqual("[0].name", name)
                .responseFieldIsEqual("[0].category", category)
                .responseFieldIsEqual("[0].price", price)
                .responseFieldIsEqual("[0].discount", discount);
        return this;
    }

}
