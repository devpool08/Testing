package org.example.restAssured.e_authentication;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestPreemptiveAuth {
    @BeforeClass
    public void setUp() {
        // Set up basic authentication credentials
        baseURI = "https://postman-echo.com/";
    }

    @Test
    public void testBasicAuth() {
        given().
                auth().
                digest("postman", "password")
                .get("/basic-auth").
                then().
                statusCode(HttpStatus.SC_OK).
                extract().
                response().
                prettyPrint();

    }

    @Test(expectedExceptions = AssertionError.class)
    public void testInvalidBasicAuth() {
        given().
                auth().
                digest("postmannbfkjne", "passwordkjnevln")
                .get("/basic-auth").
                then().
                statusCode(HttpStatus.SC_OK).
                extract().
                response().
                prettyPrint();
    }
}
