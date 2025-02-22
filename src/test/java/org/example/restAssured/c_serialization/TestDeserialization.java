package org.example.restAssured.c_serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class Product {
    private String id;
    private String name;

    @JsonProperty("data")
    private ProductData data;

    @Data
    public static class ProductData {
        private int year;
        private double price;

        @JsonProperty("CPU model")
        private String cpuModel;

        @JsonProperty("Hard disk size")
        private String hardDiskSize;
    }
}

public class TestDeserialization {
    private static final String REQUEST_PATH = "/7";
    private ObjectMapper objectMapper;

    @BeforeClass
    public void setup() {
        baseURI = "https://api.restful-api.dev/";
        basePath = "objects/";
        objectMapper = new ObjectMapper();

    }

    @Test
    public void deserializeJsonResponse() throws JsonProcessingException {
        String response = given().get(REQUEST_PATH).then().extract().asString();
        System.out.println(response);
        Product p = objectMapper.readValue(response, Product.class);
        System.out.println(p.toString());
    }

    @Test
    public void deserializeJsonResponse2() throws JsonProcessingException {
        Product product = given().get(REQUEST_PATH).then().extract().body().as(Product.class);
        System.out.println(product.toString());
    }
}
