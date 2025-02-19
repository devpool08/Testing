package org.example.restAssured.d_schemaValidation;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestJSONValidation {
    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/";
        basePath = "/api/";
    }
    @Test
    public void givenUrl_whenJsonResponseConformsToSchema_thenCorrect() {
        get("users/2").then().assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
