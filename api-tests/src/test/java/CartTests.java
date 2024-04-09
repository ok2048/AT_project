import assertions.BasicAssert;
import assertions.CartAssert;
import dto.Credentials;
import dto.ProductDto;
import endpoints.AuthApi;
import endpoints.CartApi;
import endpoints.ProductsApi;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.GenerationUtil;

public class CartTests {
    private static CartApi cartApi;
    private static ProductsApi productsApi;

    @BeforeEach
    void registerAndAuth() {
        Credentials credentials = GenerationUtil.generateCredentials();
        AuthApi.registerNewUser(credentials);
        String token = AuthApi.loginUser(credentials)
                .jsonPath().getString("access_token");
        cartApi = new CartApi(token);
        productsApi = new ProductsApi();
    }

    /**
     * Тест на получение списка товаров в корзине.
     * Шаги:
     * 1. Для создания корзины добавить в нее товар.
     * 2. Получить список товаров в корзине.
     * 3. Проверить соответствие ответа из ответа добавленному
     */
    @Epic("API тесты")
    @Feature("GET CART тесты")
    @DisplayName("Позитивный сценарий получения корзины")
    @Test
    void getCartPositive() {
        int id = productsApi.getProductId();
        ProductDto product = productsApi.getProductDTO(id);
        int quantity = 2;

        cartApi.addNewCartItem(id, quantity);
        Response response = cartApi.getCart();
        CartAssert.assertThat(response)
                .checkCartResponse(product.getId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getDiscount(),
                        quantity);
    }

    @Epic("API тесты")
    @Feature("GET CART тесты")
    @DisplayName("Негативный сценарий получения корзины - новый пользователь без корзины")
    @Test
    @Tag("negative")
    public void getCartNegativeNewUserWithoutCart() {
        Response response = cartApi.getCart();
        BasicAssert.assertThat(response)
                .statusCodeIsEqual(404);
    }

    /**
     * Тест на добавление товаров в корзину.
     * Шаги:
     * 1. Положить в корзину quantity товаров.
     * 2. Проверить, что в корзине quantity товаров.
     * 3. Положить в корзину quantity товаров.
     * 4. Проверить, что в корзине quantity*2 товаров.
     */
    @Epic("API тесты")
    @Feature("POST CART тесты")
    @DisplayName("Позитивный сценарий добавления товара в корзину")
    @Test
    public void postCartItemPositive() {
        int id = productsApi.getProductId();
        ProductDto product = productsApi.getProductDTO(id);
        int quantity = 2;

        cartApi.addNewCartItem(id, quantity);
        Response response = cartApi.getCart();
        CartAssert.assertThat(response)
                .checkCartResponse(product.getId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getDiscount(),
                        quantity);

        cartApi.addNewCartItem(id, quantity);
        response = cartApi.getCart();
        CartAssert.assertThat(response)
                .checkCartResponse(product.getId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getDiscount(),
                        quantity * 2);
    }

    /**
     * Тест на удаление из корзины.
     * Шаги:
     * 1. Положить в корзину 2 товара.
     * 2. Удалить товар из корзины.
     * 3. Проверить, что в корзине остался 1 товар.
     * 4. Удалить товар из корзины.
     * 5. Проверить, что корзина пуста
     */
    @Epic("API тесты")
    @Feature("DELETE CART тесты")
    @DisplayName("Позитивный сценарий удаления товара из корзины")
    @Test
    void deleteCartItemPositive() {
        int id = productsApi.getProductId();
        ProductDto product = productsApi.getProductDTO(id);

        cartApi.addNewCartItem(id, 2);

        cartApi.deleteCartItem(id);
        Response response = cartApi.getCart();
        CartAssert.assertThat(response)
                .checkCartResponse(product.getId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getDiscount(),
                        1);

        cartApi.deleteCartItem(id);
        response = cartApi.getCart();
        CartAssert.assertThat(response).checkCartIsEmpty();
    }

}
