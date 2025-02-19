package org.example.restAssured.e_authentication;

import static io.restassured.RestAssured.*;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestOAuth {
    private static String TOKEN;

    @BeforeClass
    public void setUp() {
        // Set the base URI for the REST API
        baseURI = "https://api.github.com";
        TOKEN = Dotenv.load().get("MY_API_TOKEN");
    }

    @Test
    public void testOAuth() {
        given().
                auth().
                oauth2(TOKEN).
                when().
                get("/user/repos").
                then().
                statusCode(HttpStatus.SC_OK).
                log().
                body();
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testInvalidOAuth() {
        given().
                auth().
                oauth2(TOKEN + "Invalid").
                when().
                get("/user/repos").
                then().
                statusCode(HttpStatus.SC_OK).
                log().
                body();
    }
}