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
    public void testDigestAuthValidInput() {
        System.out.println(baseURI);
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

    @Test
    public void testDigestAuthInvalidInput() {
        given().
                auth().
                digest("postmannbfkjne", "passwordkjnevln")
                .get("/basic-auth").
                then().
                statusCode(HttpStatus.SC_UNAUTHORIZED).
                extract().
                response().
                prettyPrint();
    }
}
