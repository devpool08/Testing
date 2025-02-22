package org.example.restAssured.c_serialization;


import static io.restassured.RestAssured.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@Data
class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
}

public class TestDeserializer {
    private ObjectMapper mapper;

    @BeforeClass
    private void setup() {
        baseURI = "https://jsonplaceholder.typicode.com";
        basePath = "/posts";
        mapper = new ObjectMapper();
    }

    @Test
    @SneakyThrows
    public void testDeserializer() {
        String response = given().
                get().
                then().
                extract().
                body().asString();
        List<Post> posts = mapper.
                readValue(response, mapper.
                        getTypeFactory().
                        constructCollectionType(List.class, Post.class));
        Post post = posts.get(0);
        System.out.println("Title: " + post.getTitle());
        System.out.println("Body: " + post.getBody());
        System.out.println("User ID: " + post.getUserId());
        System.out.println("Post ID: " + post.getId());
    }

    @Test
    @SuppressWarnings("All")
    @SneakyThrows
    public void testDeserializer2(){
        List posts = given().
                get().
                then().
                extract().
                body().as(List.class);
        for (Object post : posts) {
            Post post1 = mapper.readValue(mapper.writeValueAsString(post), Post.class);
            System.out.println("Id is : " + post1.getId());
        }
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        Post[] posts2 = given().
                get().
                then().
                extract().
                body().as(Post[].class);
        for (Post post : posts2) {
            System.out.println("Post ID: " + post.getId());

        }
        Post post = posts2[0];
        System.out.println(post.toString());
    }


}
