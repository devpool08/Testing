package org.example.restAssured.e_authentication;

import static io.restassured.RestAssured.*;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.specification.RequestSpecification;
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
    public void testOAuthValidInput() {
//        RequestSpecification spec=new RequestSpecBuilder().setAuth(oauth2(TOKEN)).build();
        System.out.println(baseURI);
        given().
                auth().
                oauth2(TOKEN).
           when().
                get("/user/repos").
           then().
                statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testInvalidOAuthInvalidInput() {
        given().
                auth().
                oauth2(TOKEN + "Invalid").
            when().
                get("/user/repos").
            then().
                statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}