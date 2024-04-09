package utils;

import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class RestApiBuilder {
    public RestApiBuilder(String baseUrl) {
        requestSpecification = given().baseUri(baseUrl)
                .config(RestAssuredConfig
                        .config()
                        .httpClient(HttpClientConfig
                                .httpClientConfig()
                                .setParam("http.connection.timeout", 5000)))
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation();
    }

    public RequestSpecification build() {
        return requestSpecification;
    }

    public RestApiBuilder addAuth(String token) {
        requestSpecification.auth().oauth2(token);
        return this;
    }

    public RestApiBuilder addHeader(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);
        return this;
    }


}
