package org.example.restAssured.e_authentication;

import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBasicAuth {
    @BeforeClass
    public void setUp() {
        // Set up basic authentication credentials
        baseURI = "https://postman-echo.com/";
    }

    @Test()
    public void testBasicAuth() {
        System.out.println(baseURI);
        given().
                auth().
                basic("postman", "password").
                when().
                get("/basic-auth").
                then().
                statusCode(HttpStatus.SC_OK);
        // statusCode(200);

    }

    @Test(expectedExceptions = AssertionError.class)
    public void testInvalidBasicAuth() {

        given().
                auth().
                basic("postman", "passwordkjnvejvn").
                when().
                get("/basic-auth").
                then().
                statusCode(HttpStatus.SC_OK);
    }
}
