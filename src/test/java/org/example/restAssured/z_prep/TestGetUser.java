package org.example.restAssured.z_prep;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetUser extends TestBase {
    @Test
    public void getUsers() {
        given().
                queryParam("page", 2).
                when().
                get().
                prettyPrint();
    }

    @Test
    public void getUser() {
        given().
                when().
                get("/2").
                prettyPrint();
    }

    @Test
    public void notFoundUser() {
        given().
                when().
                get("/23").
                then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void createUser() {
        given().
                body("""             
                        {
                           "name": "John Doe",
                           "job": "Software Engineer
                        }
                        """).
                when().
                post("/users").
                then().
                statusCode(HttpStatus.SC_CREATED);
    }
    @Test
    public void updateUser() {
        given().
                body("""             
                        {
                           "name": "John Doe Updated",
                           "job": "Senior Software Engineer
                        }
                        """).
                when().
                put("/users/2").
                then().
                statusCode(HttpStatus.SC_OK);
    }
}

