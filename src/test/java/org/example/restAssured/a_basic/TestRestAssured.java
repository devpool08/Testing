package org.example.restAssured.a_basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRestAssured {

    @BeforeClass
    public void setup() {
        // Set the base URI for the REST API
        RestAssured.baseURI = "https://reqres.in";
        // Set the base path for the REST API
        RestAssured.basePath = "/api/";
    }

    @Test
    public void testOpenWebPage() {
        // Perform a GET request to the specified endpoint and extract the response
        Response response = RestAssured
                .given() // Given no specific request parameters
                .when() // When performing the GET request
                .get("/users?page=2") // To the endpoint /users?page=2
                .then() // Then extract the response
                .extract().response();

        // Print the response body
        response.prettyPrint();
    }

    @Test
    public void testStatusCode() {
        // Perform a GET request and assert the status code is 200
        RestAssured
                .given() // Given no specific request parameters
                .when() // When performing the GET request
                .get("/users?page=2") // To the endpoint /users?page=2
                .then() // Then assert the status code
                .statusCode(200); // Assert the status code is 200
    }

    @Test
    public void testContentType() {
        // Perform a GET request and assert the content type is application/json
        RestAssured
                .given() // Given no specific request parameters
                .when() // When performing the GET request
                .get("/users?page=2") // To the endpoint /users?page=2
                .then() // Then assert the content type
                .contentType("application/json"); // Assert the content type is application/json
    }

}