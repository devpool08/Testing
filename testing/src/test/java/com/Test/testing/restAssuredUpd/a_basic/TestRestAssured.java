package com.Test.testing.restAssuredUpd.a_basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRestAssured {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/";
    }

    @Test
    public void testOpenWebPage() {
        Response response = RestAssured
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .extract().response();

        response.prettyPrint();
    }

    @Test
    public void testStatusCode() {
        RestAssured
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200); // Assert the status code is 200
    }

    @Test
    public void testContentType() {
        RestAssured
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .contentType("application/json"); // Assert the content type is application/json
    }
}