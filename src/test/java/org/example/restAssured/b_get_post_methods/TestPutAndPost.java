package org.example.restAssured.b_get_post_methods;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPutAndPost {
    private static final String POST_URL = "/users";
    private static final String PUT_URL = "/users/2/";

    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/";
        basePath = "/api/";
    }

    @Test
    public void testPostRequest() {
        given().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").when().post(POST_URL).then().statusCode(201);
    }

    @Test
    public void testPutRequest() {
        given().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}").put(PUT_URL).then().statusCode(200);
    }
    @Test
    public void testDeleteRequest() {
        given().delete(PUT_URL).then().statusCode(204);
    }
}
