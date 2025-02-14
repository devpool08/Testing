package com.Test.testing.restAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRestAssuredSomeMoreFeatures {

    // Setup method to initialize base URI and base path
    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api";
    }

    // Data provider for adding users
    @DataProvider(name = "userDataProvider")
    public Object[][] userDataProvider() {
        return new Object[][]{
                {"morpheus", "leader"},
                {"neo", "the one"},
                {"trinity", "hacker"}
        };
    }

    // Test to add a new user using data provider
    @Test(dataProvider = "userDataProvider")
    public void testAddUser(String name, String job) {
        String requestBody = String.format("{ \"name\": \"%s\", \"job\": \"%s\" }", name, job);
        given()
                .header("Content-Type", "application/json") // Set content type
                .body(requestBody) // Set request body
                .when()
                .post("/users") // Perform POST request
                .then()
                .statusCode(201) // Assert the status code is 201
                .body("name", equalTo(name)) // Assert the name in the response
                .body("job", equalTo(job)); // Assert the job in the response
    }

    // Test to update a user
    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";
        given()
                .header("Content-Type", "application/json") // Set content type
                .body(requestBody) // Set request body
                .when()
                .put("/users/2") // Perform PUT request
                .then()
                .statusCode(200) // Assert the status code is 200
                .body("name", equalTo("morpheus")) // Assert the name in the response
                .body("job", equalTo("zion resident")); // Assert the job in the response
    }

    @Test
    public void testDeleteUser() {
        given()
                .header("Content-Type", "application/json") // Set content type
                .when()
                .delete("/users/2") // Perform DELETE request
                .then()
                .statusCode(204); // Assert the status code is 204
    }

}