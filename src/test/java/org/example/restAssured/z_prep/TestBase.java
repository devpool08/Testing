package org.example.restAssured.z_prep;

import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;
//https://reqres.in/api/users?page=2

public class TestBase {
    @BeforeClass
    public void setup() {
        baseURI="https://reqres.in";
        basePath="/api/users";
    }
}
