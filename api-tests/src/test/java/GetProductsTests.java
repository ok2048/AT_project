import assertions.ProductsAssert;
import dto.Credentials;
import endpoints.AuthApi;
import endpoints.ProductsApi;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.GenerationUtil;

public class GetProductsTests {
    private static ProductsApi productsApi;

    @BeforeAll
    static void registerAndAuth() {
        Credentials credentials = GenerationUtil.generateCredentials();
        AuthApi.registerNewUser(credentials);
        productsApi = new ProductsApi();
    }

    @Epic("API тесты")
    @Feature("GET PRODUCTS тесты")
    @DisplayName("Позитивный сценарий получения продукта по ID")
    @Test
    void getProductPositive() {
        Response response = productsApi.getProduct(1);
        ProductsAssert.assertThat(response)
                .checkProductResponse(1,
                        "HP Pavilion Laptop",
                        "Electronics",
                        10.99f,
                        10.0f);
    }

}
