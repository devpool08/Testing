package org.example.restAssured.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

@Data
class User {
    private String name;
    private String job;
}

public class TestSerialization1 {

    private static final String POST_URL = "/users";
    private static final String PUT_URL = "/users/2/";
    private String json;
    private User user;
    private ObjectMapper objectMapper;

    @SneakyThrows
    @BeforeClass
    public void setUp() {
        // Create a User object
        user = new User();
        user.setName("John Doe");
        user.setJob("Software Developer");

        // Use ObjectMapper to serialize the User object to JSON
        objectMapper = new ObjectMapper();
        json = objectMapper.writeValueAsString(user);

        System.out.println("Serialized JSON: " + json);

        // Sample JSON response
        String jsonResponse = "{\"name\":\"Alice\", \"job\":\"Engineer\"}";

        // Use ObjectMapper to deserialize the JSON response to a User object
        User deserializedUser = objectMapper.readValue(jsonResponse, User.class);

        System.out.println("Deserialized User: " + deserializedUser.getName() + ", " + deserializedUser.getJob());

        baseURI = "https://reqres.in/";
        basePath = "/api/";
    }

    @Test
    public void testPostRequest() {
        given().body(json).post(POST_URL).then().statusCode(201);
    }

    @SneakyThrows
    @Test
    public void testPutRequest() {
        user.setJob("Engineer");
        json=objectMapper.writeValueAsString(user);
        given().body(json).put(PUT_URL).then().statusCode(200);

    }
}