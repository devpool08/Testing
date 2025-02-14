package com.Test.testing.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRestAssuredGetTesting {
    @Test
    public void testGet() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody().prettyPrint());
        System.out.println(response.statusCode());
        System.out.println(response.header("Content-Type"));
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
