package org.example.restAssured.z_prep;

import static io.restassured.RestAssured.*;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Data
@ToString
@Builder
class Pojo {
    private String name;
    private int age;
    private String email;
    private String password;
}

public class TestLocalApi {
    @BeforeClass
    public void setup() {
        baseURI="http://localhost";
        port = 8080;
        basePath="/api";
    }
    @Test
    public void testHealthCheck() {
        get("/hello").then().statusCode(HttpStatus.SC_OK).extract().response().prettyPrint();
    }
    @Test
    public void testPostHello() {
        Pojo pojo = Pojo.builder().age(21).password("pass123").email("user@dom.com").name("deb").build();

        given().body(pojo).when().post("/users").then().statusCode(HttpStatus).extract().response().prettyPrint();
    }
}
