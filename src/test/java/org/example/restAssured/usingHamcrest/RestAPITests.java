package org.example.restAssured.usingHamcrest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAPITests {
    private static final String GET_URL = "https://reqres.in/api/users?page=2";
    private static final String POST_URL = "https://reqres.in/api/users";

    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
        get(GET_URL).
                then().
                statusCode(200).
                assertThat().//This method is used to start an assertion on the response.
                body("data[0].id", equalTo(7));//This asserts that the JSON response body contains a key data
    }

    @Test
    public void givenUrl_whenJsonResponseHasArrayWithGivenValuesUnderKey_thenCorrect() {
        get(GET_URL).then().
                assertThat().
                body("data.id", hasItems(7, 8, 9, 10, 11));
    }

    @Test
    public void whenRequestGet_thenOK() {
        when().request("GET", GET_URL).then().statusCode(200);
    }

    @Test
    public void whenRequestedPost_thenCreated() {
        with().body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").when()
                .request("POST", POST_URL)
                .then()
                .statusCode(201);
    }

    @Test
    public void whenMeasureResponseTime_thenOK() {
        long time = get(GET_URL).time();
        System.out.println("Response time: " + time + " ms");
        get(GET_URL).
                then().
                time(lessThan(5000L));
    }

    @Test
    public void whenLogRequest_thenOK() {
        given().log().all()
                .when().get(GET_URL)
                .then().statusCode(200);
    }

    @Test
    public void whenLogResponse_thenOK() {
        when().get(GET_URL)
                .then().log().body().statusCode(200);
    }
}
