package com.Test.testing.restAssuredUpd.a_basic;

import static io.restassured.RestAssured.*;


import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRestAssuredStaticImpl {

    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api/";
    }

    @Test
    public void testOpenWebPage() {
        Response response =
                given()
                        .when()
                        .get("/users?page=2")
                        .then()
                        .extract().response();

        response.prettyPrint();
    }

    @Test
    public void testStatusCode() {
        given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200); // Assert the status code is 200
    }

    @Test
    public void testContentType() {
        given()
                .when()
                .get("/users?page=2")
                .then()
                .contentType("application/json"); // Assert the content type is application/json
    }
}