package com.Test.testing.restAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestStaticImplementation {
    private RequestSpecification requestSpec;

    // Setup method to initialize base URI and base path
    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api";
        requestSpec = given().baseUri(baseURI).basePath(basePath);
    }

    // Test to verify the GET request and response status code
    @Test
    public void testGetWithInstanceImplementation() {
        Response response = requestSpec.get("/users?page=2");
        response.prettyPrint(); // Print the response body
        Assert.assertEquals(response.getStatusCode(), 200); // Assert the status code is 200
    }

    // Test to verify the ID in the response body
    @Test
    public void testGetCheckId() {
        requestSpec.get("/users?page=2")
                .then()
                .statusCode(200) // Assert the status code is 200
                .body("data[1].id", equalTo(8)); // Assert the ID is 8
    }

    // Data provider for parameterized tests
    @DataProvider(name = "userIds")
    public Object[][] createUserIds() {
        return new Object[][]{{1}, {2}, {3}};
    }

    // Test to verify the GET request with different user IDs
    @Test(dataProvider = "userIds")
    public void testGetUserById(int userId) {
        requestSpec.get("/users/" + userId)
                .then()
                .statusCode(200); // Assert the status code is 200
    }

    // Test with custom logging for requests and responses
    @Test
    public void testWithCustomLogging() {
        requestSpec.log().all() // Log the request details
                .get("/users?page=2")
                .then()
                .log().ifError() // Log the response details if there is an error
                .statusCode(200); // Assert the status code is 200
    }

    // Test to verify the response time
    @Test
    public void testResponseTime() {
        requestSpec.get("/users?page=2")
                .then()
                .time(lessThan(2000L)); // Assert the response time is less than 2000 milliseconds
    }
}