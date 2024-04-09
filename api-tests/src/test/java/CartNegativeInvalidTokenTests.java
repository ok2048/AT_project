import assertions.BasicAssert;
import endpoints.CartApi;
import endpoints.ProductsApi;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CartNegativeInvalidTokenTests {
    private CartApi cartApi;
    private ProductsApi productsApi;

    @BeforeEach
    void setup() {
        String token = "invalid_token";
        cartApi = new CartApi(token);
        productsApi = new ProductsApi();
    }

    @Epic("API тесты")
    @Feature("GET CART тесты")
    @DisplayName("Негативный сценарий получения корзины - неверный токен")
    @Test
    @Tag("negative")
    public void getCartNegativeInvalidToken() {
        Response response = cartApi.getCart();
        BasicAssert.assertThat(response).statusCodeIsEqual(422);
    }

    @Epic("API тесты")
    @Feature("POST CART тесты")
    @DisplayName("Негативный сценарий добавления товара в корзину - неверный токен")
    @Test
    @Tag("negative")
    public void postCartItemNegativeInvalidToken() {
        int id = productsApi.getProductId();
        int quantity = 2;

        Response response = cartApi.addNewCartItem(id, quantity);
        BasicAssert.assertThat(response).statusCodeIsEqual(422);
    }

    @Epic("API тесты")
    @Feature("DELETE CART тесты")
    @DisplayName("Негативный сценарий удаления товара из корзины - неверный токен")
    @Test
    @Tag("negative")
    public void deleteCartNegativeInvalidToken() {
        int id = productsApi.getProductId();
        Response response = cartApi.deleteCartItem(id);
        BasicAssert.assertThat(response).statusCodeIsEqual(422);
    }
}
