package endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RestApiBuilder;

public class BasicApi {
    protected String token;

    public BasicApi(String token) {
        this.token = token;
    }

    public RequestSpecification getBuilder() {
        RestApiBuilder restApiBuilder = new RestApiBuilder(Urls.BASE_URI);
        if (token != null) {
            restApiBuilder.addAuth(token);
        }
        return restApiBuilder.build();
    }

    public RequestSpecification getBuilderWithoutAuth() {
        return new RestApiBuilder(Urls.BASE_URI)
                .build();
    }

    protected static String toJson(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    protected static <T> T toDtoObject(Response response, String path, Class<T> tClass) {
        return response.jsonPath().getObject(path, tClass);
    }

}