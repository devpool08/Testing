package org.example.restAssured.c_serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    private String name;
    private String job;
}

public class TestSerialization1 {

    private static final String POST_URL = "/users";
    private static final String GET_URL = "/users/2";
    private User user;
    private ObjectMapper objectMapper;

    @BeforeClass
    public void setUp() {
        baseURI = "https://reqres.in/";
        basePath = "/api/";
        user = new User("John Doe", "Software Developer");
        objectMapper = new ObjectMapper();
    }

    @Test
    public void sendSerializedRequest() {
        try {
            String json = objectMapper.writeValueAsString(user);
            given().
                    body(json).
                    post(POST_URL).
                    then().
                    statusCode(HttpStatus.SC_CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deserializeJsonResponse() {
        try {
            String response = given().
                    get(GET_URL).
                    then().
                    statusCode(HttpStatus.SC_OK).
                    extract().
                    asString();
            User user1 = objectMapper.readValue(response, User.class);
            System.out.println(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}