package org.example.restAssured.c_serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
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
class Entity {
    private String name;
    private String job;
}

public class TestSerialization {
    private static final String REQUEST_PATH = "/users";
    private static Entity entity;
    private ObjectMapper objectMapper;

    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api/";
        entity = new Entity();
        objectMapper = new ObjectMapper();
    }


    @Test
    public void sendSerializedRequest() throws JsonProcessingException {
        entity = new Entity("john", "test");
        String jsonSchema = objectMapper.writeValueAsString(entity);
        given().
                body(jsonSchema).
                when().
                post(REQUEST_PATH).
                then().
                statusCode(HttpStatus.SC_CREATED);
    }

}