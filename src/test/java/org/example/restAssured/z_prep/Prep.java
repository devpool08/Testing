package org.example.restAssured.z_prep;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.Data;
import lombok.ToString;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

import lombok.Data;

@Data
class User {
    private int id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String avatar;
}

public class Prep {
    @Test
    public void get() throws JsonProcessingException {




//        System.out.println(given().when().get("https://reqres.in/api/unknown").then().extract().response().jsonPath().getMap("data[0]").toString());
//
//        Response pojo = given().when().get("https://reqres.in/api/unknown/2").then().extract().response();
//        Pojo pojo1 = new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(pojo.path("data[1]")), Pojo.class);
//        System.out.println(pojo1.toString());
    }
}