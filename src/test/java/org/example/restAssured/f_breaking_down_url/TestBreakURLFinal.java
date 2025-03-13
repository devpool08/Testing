package org.example.restAssured.f_breaking_down_url;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestBreakURLFinal {
    @Test
    public static void breakDown() {
        // Setting Base URI
        baseURI = "https://reqres.in";

        // Setting Base Path (Applies to all requests)
        basePath = "/api";

        // Setting Root Path (For extracting JSON elements easily)
       rootPath = "data";

        // API Call with Path & Query Parameters
        Response response = given()
                .pathParam("userId", 2)  // Path parameter
                .queryParam("page", 1)   // Query parameter
                .queryParam("delay", 3)  // Query parameter
                .when()
                .get("/users/{userId}")  // Using path parameter
                .then()
                .statusCode(200)  // Validate HTTP Status Code
                .body("id", equalTo(2))  // Validate Response Data
                .extract().response();// Extract response for further processing
        response.prettyPrint();

        // Extract & Print Specific Values Using RootPath
        String firstName = response.path("data.first_name");
        String lastName = response.path("data.last_name");
        System.out.println("User Name: " + firstName + " " + lastName);
    }
}
