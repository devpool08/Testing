# RestAssured Testing with TestNG

This project demonstrates how to use RestAssured for API testing in Java, integrated with TestNG for test execution. The
examples cover basic GET requests, status code validation, and content type validation.

# REST Assured API Testing

## Overview

This project demonstrates how to use REST Assured, a Java library for testing HTTP-based REST services. It simplifies
the process of sending HTTP requests and handling responses. This documentation provides details on testing with the
ReqRes, a simulated REST API.

## Project Structure

The project includes two Java classes designed for testing the RESTful API:

1. `TestRestAssuredGetTesting`
2. `TestRestAssured`

### Key REST Assured Methods

- **`get()`**: Executes a GET request to the specified URI.
- **`given()`**: Begins a specification of a request.
- **`when()`**: Defines a condition of the REST Assured specification.
- **`then()`**: Contains assertions or actions that can be performed after the request is made.
- **`statusCode()`**: Asserts the expected status code.
- **`contentType()`**: Asserts the expected type of content.
- **`extract()`**: Allows extracting data from the response.

## Usage

### TestRestAssuredGetTesting Class

This class encapsulates the basic use of REST Assured without utilising the BDD-style methods.

```java
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
```

- `testGet()`: Sends a GET request to retrieve user data from the second page. It prints the response body, status code,
  and 'Content-Type' header. It asserts that the status code is `200`.

### TestRestAssured Class

This class uses REST Assured's given-when-then syntax for clear, readable tests.

```java
public class TestRestAssured {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/";
    }

    @Test
    public void testOpenWebPage() {
        Response response = RestAssured
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .extract().response();

        response.prettyPrint();
    }

    @Test
    public void testStatusCode() {
        RestAssured
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200); // Assert the status code is 200
    }

    @Test
    public void testContentType() {
        RestAssured
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .contentType("application/json"); // Assert the content type is application/json
    }
}
```

- `setup()`: Initializes URIs to avoid redundancy in each test.
- `testOpenWebPage()`: Fetches user data for a specific page and prints the output.
- `testStatusCode()`: Tests if the successful status code `200` is returned.
- `testContentType()`: Confirms that the response returns data in 'application/json' format.

## Running the Tests

1. Add REST Assured dependencies to the project’s build configuration file (`pom.xml` or `build.gradle`).
2. Import the project into your preferred Java IDE.
3. Navigate to test classes and run the tests individually or all at once.

## Conclusion

The demonstrated examples highlight basic API testing scenarios with REST Assured, showing a powerful way to validate
HTTP service behaviors effectively. By integrating these tests into continuous integration (CI) environments, consistent
API performance and reliability can be ensured, contributing to refined software quality.

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="All Test Suite" parallel="tests">
    <test verbose="2" preserve-order="true" name="TestNG">
        <classes>
            <class name="com.Test.testing.restAssured.TestPostMethods">
                <methods>
                    <include name="testAuthentication"/>
                    <include name="testFileUpload"/>
                    <include name="testCustomFilters"/>
                </methods>
            </class>
            <class name="com.Test.testing.restAssured.TestRestAssuredGetTesting">
                <methods>
                    <include name="testGet"/>
                </methods>
            </class>
            <class name="com.Test.testing.restAssured.TestRestAssuredSomeMoreFeatures">
                <methods>
                    <include name="testAddUser"/>
                    <include name="testUpdateUser"/>
                    <include name="testDeleteUser"/>
                </methods>
            </class>
            <class name="com.Test.testing.restAssured.TestStaticImplementation">
                <methods>
                    <include name="testGetWithInstanceImplementation"/>
                    <include name="testGetCheckId"/>
                    <include name="testGetUserById"/>
                    <include name="testWithCustomLogging"/>
                    <include name="testResponseTime"/>
                </methods>
            </class>
            <class name="com.Test.testing.testngLearning.demo2Testing">
                <methods>
                    <include name="testMethod1"/>
                    <include name="testMethod2"/>
                </methods>
            </class>
            <class name="com.Test.testing.testngLearning.demoTesting">
                <methods>
                    <include name="test"/>
                    <include name="test2"/>
                    <include name="test3"/>
                    <include name="test4"/>
                    <include name="test5"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>
```

```xml

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="RestAssuredUpdatedTest" parallel="tests">
    <test verbose="2" preserve-order="true" name="TestRestAssured">
        <classes>
            <class name="com.Test.testing.restAssuredUpd.a_basic.TestRestAssured"/>
            <class name="com.Test.testing.restAssuredUpd.a_basic.TestRestAssuredStaticImpl"/>
        </classes>
    </test>
</suite>
```

To run the tests, you can use the following Maven commands:

```sh
mvn test -DsuiteXmlFile=testng.xml
mvn test -DsuiteXmlFile=restAssuredWithTestNG.xml
```