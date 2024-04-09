package endpoints;

import dto.ProductDto;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ProductsApi extends BasicApi {

    public ProductsApi() {
        super(null);
    }

    @Step("Отправить запрос на получение каталога товаров")
    public Response getProducts() {
        return getBuilderWithoutAuth()
                .get(Urls.PRODUCTS);
    }

    @Step("Отправить запрос на получение товара по id")
    public Response getProduct(int id) {
        return getBuilderWithoutAuth()
                .get(Urls.PRODUCTS + "/" + id);
    }

    @Step("Получить id любого товара из каталога")
    public int getProductId() {
        return getBuilderWithoutAuth()
                .get(Urls.PRODUCTS)
                .jsonPath().getInt("[0].id");
    }

    @Step("Получить товара из каталога по id")
    public ProductDto getProductDTO(int id) {
        return toDtoObject(getBuilderWithoutAuth()
                        .get(Urls.PRODUCTS + "/" + id),
                "[0]",
                ProductDto.class);
    }

    @Step("Отправить запрос на добавление товара в каталог")
    public Response addNewProduct(ProductDto product) {
        return getBuilderWithoutAuth()
                .body(product)
                .post(Urls.PRODUCTS);
    }

}
