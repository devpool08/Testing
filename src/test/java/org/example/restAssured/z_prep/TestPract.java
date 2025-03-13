package org.example.restAssured.z_prep;

import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.module.jsv.JsonSchemaValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@lombok.Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class GetUser{
    @JsonProperty("id")
    private int data;
    @JsonProperty("name")
    private String  name;
    @JsonProperty("year")
    int year;
    @JsonProperty("color")
    private String color;
    @JsonProperty("pantone_value")
    private String value;
}

public class TestPract {
    private static final String REQUEST_PATH="/unknown/";
    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in";
        basePath="/api";
    }
    @SneakyThrows
    @Test
    public void test1() {
        Object path = given().when().get(REQUEST_PATH).then().statusCode(HttpStatus.SC_OK).extract().response().path("data[0]");
        System.out.println(path.toString());
        GetUser user=new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(path),GetUser.class);
        System.out.println(user.toString());
    }
    @Test
    public void test2(){
        given().when().get(REQUEST_PATH).then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("sh.json"));
    }
}


