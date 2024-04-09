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

public class CartNegativeWithoutTokenTests {
    private CartApi cartApi;
    private ProductsApi productsApi;

    @BeforeEach
    void setup() {
        String token = null;
        cartApi = new CartApi(token);
        productsApi = new ProductsApi();
    }

    @Epic("API тесты")
    @Feature("GET CART тесты")
    @DisplayName("Негативный сценарий получения корзины - отсутствует токен")
    @Test
    @Tag("negative")
    public void getCartNegativeWithoutToken() {
        Response response = cartApi.getCart();
        BasicAssert.assertThat(response).statusCodeIsEqual(401);
    }

    @Epic("API тесты")
    @Feature("POST CART тесты")
    @DisplayName("Негативный сценарий добавления товара в корзину - отсутствует токен")
    @Test
    @Tag("negative")
    public void postCartItemNegativeWithoutToken() {
        int id = productsApi.getProductId();
        int quantity = 2;

        Response response = cartApi.addNewCartItem(id, quantity);
        BasicAssert.assertThat(response).statusCodeIsEqual(401);
    }

    @Epic("API тесты")
    @Feature("DELETE CART тесты")
    @DisplayName("Негативный сценарий удаления товара из корзины - отсутствует токен")
    @Test
    @Tag("negative")
    public void deleteCartNegativeWithoutToken() {
        int id = productsApi.getProductId();
        Response response = cartApi.deleteCartItem(id);
        BasicAssert.assertThat(response).statusCodeIsEqual(401);
    }

}
