package org.example.restAssured.f_breaking_down_url;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Entity{
    @JsonProperty("data")
    private UserData data;
    @JsonProperty("support")
    private UserSupport userSupport;
    @Data
    public static class UserData {
        @JsonProperty("id")
        private int id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("year")
        private int year;

        @JsonProperty("color")
        private String color;

        @JsonProperty("pantone_value")
        private String pantone_value;
    }
    @Data
    public static class UserSupport {
        @JsonProperty("url")
        private String url;

        @JsonProperty("text")
        private String text;
    }

}

public class TestUrlBreaking {
    /// https://reqres.in/api/users?page=2  breaking down URL
    /// (https://reqres.in baseURI
    /// api is basePath
    /// users is the path Parameter
    /// page=2 is query parameter
    private static final String REQUEST_PATH = "/user";
    private static String responseString;
    private ObjectMapper objectMapper;

    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api";
        //baseURI-->basePath-->rootPath // although rootPath is not used we can use this in some other example
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetUsers() {
        // URL is https://reqres.in/api/users?page=2
        responseString= given().
                queryParam("page", 2).
                queryParam("id", 7).
                when().
                get(REQUEST_PATH).
                then().
                statusCode(HttpStatus.SC_OK).
                extract().
                body().
                asPrettyString();
        System.out.println(responseString);
    }
    @Test(dependsOnMethods = "testGetUsers")
    @SneakyThrows
    public void testDeserialization() {
        Entity entity = objectMapper.readValue(responseString, Entity.class);
        System.out.println(entity.toString());
    }
}
/*
* This is the response
* {
    "data": {
        "id": 7,
        "name": "sand dollar",
        "year": 2006,
        "color": "#DECDBE",
        "pantone_value": "13-1106"
    },
    "support": {
        "url": "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",
        "text": "Tired of writing endless social media content? Let Content Caddy generate it for you."
    }
}*/