package com.Test.testing.restAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class TestPostMethods {

    // Setup method to initialize base URI and base path
    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api";
    }

    // Test to verify basic authentication
    @Test
    public void testAuthentication() {
        given()
            .auth().basic("username", "password") // Set basic authentication
        .when()
            .post("/secure-endpoint") // Perform POST request
        .then()
            .statusCode(200); // Assert the status code is 200
    }

    // Test to verify file upload
    @Test
    public void testFileUpload() {
        given()
            .multiPart("file", new File("C:\\PS\\ProjectsFiles\\testing\\DemoUploadFile")) // Set file to upload
        .when()
            .post("/upload") // Perform POST request
        .then()
            .statusCode(201); // Assert the status code is 201
    }

    // Test to verify custom filters for logging requests and responses
    @Test
    public void testCustomFilters() {
        given()
            .filter(new RequestLoggingFilter()) // Add request logging filter
            .filter(new ResponseLoggingFilter()) // Add response logging filter
        .when()
            .post("/users") // Perform POST request
        .then()
            .statusCode(201); // Assert the status code is 201
    }
}