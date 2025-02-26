package org.example.restAssured.f_breaking_down_url;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

@Data
class Post {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
}

public class TestTaskObjective {
    private ObjectMapper mapper;

    @BeforeClass
    private void setup() {
        baseURI = "https://jsonplaceholder.typicode.com/posts";
//        basePath = "/posts";
        mapper = new ObjectMapper();
    }

    @SneakyThrows
    @Test
    public void getTaskObjectiveById() {
        List posts= given().
                queryParam("id", 1L).
                when().
                get().
                then().
                extract().
                body().as(List.class);
        System.out.println(posts.get(0));
        String jsonResponse=mapper.writeValueAsString(posts.get(0));
        System.out.println(jsonResponse);
        mapper.readValue(jsonResponse, Post.class);
        System.out.println();
    }
}
