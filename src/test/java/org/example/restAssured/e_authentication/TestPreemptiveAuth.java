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
    public void testPreemptiveAuthValidInput() throws InterruptedException {
        System.out.println(baseURI);
        given().
                auth().
                preemptive().
                basic("postman", "password").
                when().
                get("basic-auth").
                then().
                statusCode(HttpStatus.SC_OK).
                extract().
                response().
                prettyPrint();
    }

    @Test
    public void testPreemptiveAuthInvalidInput() {
        given().
                auth().preemptive().
                basic("postmannbfkjne", "passwordkjnevln").
                when().
                get("basic-auth").
                then().
                statusCode(HttpStatus.SC_UNAUTHORIZED).
                extract().
                response().
                prettyPrint();
    }
}
