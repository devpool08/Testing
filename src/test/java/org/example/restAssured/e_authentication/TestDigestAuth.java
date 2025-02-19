package org.example.restAssured.e_authentication;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestDigestAuth {
    @BeforeClass
    public void setUp() {
        // Set up basic authentication credentials
        baseURI = "https://postman-echo.com/";
    }

    @Test
    public void testDigestAuthValidInput() throws InterruptedException {
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

    @Test(expectedExceptions = AssertionError.class)
    public void testDigestAuthInvalidInput() {
        given().
                auth().preemptive().
                basic("postmannbfkjne", "passwordkjnevln").
                when().
                get("basic-auth").
                then().
                statusCode(HttpStatus.SC_OK).
                extract().
                response().
                prettyPrint();
    }
}
