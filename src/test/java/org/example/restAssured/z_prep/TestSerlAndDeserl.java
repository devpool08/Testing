package org.example.restAssured.z_prep;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.Response;
import lombok.Data;
import lombok.ToString;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // Ignore null values
class User {
    private int id;
    private String name;
    private String address; // If address is null, it will be ignored
}

@JsonIgnoreProperties({"password", "email"})  // Ignore these fields
class User2 {
    private int id;
    private String name;
    private String password;
    private String email;
}
@Data
@ToString
@JsonIgnoreProperties({"ignore1", "ignore2"}) // Ignore these fields
@JsonInclude(JsonInclude.Include.NON_NULL)
class Todo {
    @JsonProperty("userId")
    private int userId;

    @JsonProperty("id")
    private int todoNumber;

    @JsonProperty("title")
    private String title;

    @JsonProperty("completed")
    private boolean completed;

    @JsonIgnore
    private String description;

    private boolean ignore1;
    private boolean ignore2;

}


public class TestSerlAndDeserl {
    Response response;

    @BeforeClass
    public void setup() {
        response =
                get("https://jsonplaceholder.typicode.com/todos/1")
                        .then()
                        .extract()
                        .response();
    }

    @Test
    public void testSerilAndDeserl() {
        Todo todo = response.as(Todo.class);
        System.out.println("Deserialized Todo: " + todo.toString());

    }
    @Test
    public void testSerilAndDeserl2() {
        User user = response.as(User.class);
        System.out.println("Deserialized User: " + user.toString());
    }

}
