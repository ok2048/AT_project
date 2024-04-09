package endpoints;

import dto.CartItemDto;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CartApi extends BasicApi {
    public CartApi(String token) {
        super(token);
    }

    @Step("Отправить запрос на получение корзины")
    public Response getCart() {
        return getBuilder()
                .get(Urls.CART);
    }

    @Step("Отправить запрос на добавление товара в корзину")
    public Response addNewCartItem(int productId, int quantity) {
        CartItemDto cartItem = new CartItemDto()
                .setProductId(productId)
                .setQuantity(quantity);
        return getBuilder()
                .body(cartItem)
                .post(Urls.CART);
    }

    @Step("Отправить запрос на удаление товара из корзины")
    public Response deleteCartItem(int id) {
        return getBuilder()
                .delete(Urls.CART + "/" + id);
    }

}
