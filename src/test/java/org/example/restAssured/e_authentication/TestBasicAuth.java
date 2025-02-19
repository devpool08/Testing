package org.example.restAssured.e_authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBasicAuth {
    @BeforeClass
    public void setUp() {
        // Set up basic authentication credentials
        baseURI = "https://postman-echo.com/";
    }

    @Test
    public void testBasicAuth() {
        given().
                auth().
                basic("postman", "password").
                when().
                get("/basic-auth").
                then().
                statusCode(200);

    }

    @Test(expectedExceptions = AssertionError.class)
    public void testInvalidBasicAuth() {
        given().
                auth().
                basic("postman", "passwordkjnvejvn").
                when().
                get("/basic-auth").
                then().
                statusCode(200);
    }
}
