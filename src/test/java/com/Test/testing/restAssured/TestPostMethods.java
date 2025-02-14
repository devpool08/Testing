package com.Test.testing.restAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class TestPostMethods {
    private final String FILE_PATH="C:\\PS\\ProjectsFiles\\UnitTesting\\DemoUploadFile";//Make sure to chane the file path

    // Setup method to initialize base URI and base path
    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api";
    }


    // Test to verify file upload
    @Test
    public void testFileUpload() {
        given()
            .multiPart("file", new File(FILE_PATH)) // Set file to upload
        .when()
            .post("/upload") // Perform POST request
        .then()
            .statusCode(201); // Assert the status code is 201
    }

}