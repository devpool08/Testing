# Introduction to RestAssured with TestNG

## What is RestAssured?

RestAssured is an open-source Java domain-specific language (DSL) that makes testing RESTful web services simple. It
simplifies sending HTTP requests to a server and handling HTTP responses. It integrates seamlessly with testing
frameworks such as TestNG or JUnit to make API testing more concise and expressive.

## Prerequisites for Setup

To get started with RestAssured and TestNG, you need the following:

- **Java Development Kit (JDK):** Ensure you have JDK installed (version 8 or above).
- **Maven or Gradle:** These are build tools for managing dependencies and project life cycle.
- **IDE (Integrated Development Environment):** Such as IntelliJ IDEA, Eclipse, or Visual Studio Code which makes coding
  easier.
- **RestAssured and TestNG libraries:** Added as dependencies in your Maven `pom.xml` or Gradle `.build` file.

### Sample Maven Dependencies

```xml

<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>4.3.3</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## What is API Testing?

API Testing involves testing APIs (Application Programming Interfaces) directly and as part of integration testing, to
determine if they meet expectations for functionality, reliability, performance, and security. Unlike UI testing, API
testing does not focus on the look and feel of an application. Instead, it mainly concentrates on the business logic
layer of the software architecture.

## Difference Between API Testing and API Monitoring

- **API Testing** is a type of software testing that focuses on verifying that APIs work as expected. This entails
  making requests to the API and checking the responses against defined expectations (e.g., correct data, HTTP status
  codes, headers).

- **API Monitoring**, on the other hand, is about ensuring that the APIs are available, functional, and performing well
  in production. It involves checking APIs for uptime, response time, and correct functioning in a continuous manner
  over a certain period.

## Types of API Testing

1. **Functional Testing:** Verifies that the API functions as intended.
2. **Load Testing:** Tests the API's ability to handle large amounts of calls.
3. **Security Testing:** Ensures that the APIs are secure from external threats.
4. **Reliability Testing:** Checks the API’s consistency in returning the results.
5. **Integration Testing:** Verifies if the APIs integrate well with other parts of the system.
6. **UI Testing for API (sometimes):** While APIs are typically backend services, they can sometimes involve testing how
   an API integrates with a frontend interface.

By utilizing RestAssured with TestNG, these types of tests can be automated, providing regular feedback on the health
and functionality of your APIs.

## Conclusion

With RestAssured, testers can write powerful, maintainable tests for RESTful APIs. Combined with TestNG, RestAssured
helps in generating comprehensive reports of the API tests, making it an indispensable tool for developers and testers
aiming to deliver robust and high-quality software applications.

Happy testing!

---

# Advanced RestAssured Tutorial

## Introduction to RestAssured

RestAssured is a Java library that simplifies testing of REST-based services. It is designed to write elegant and
readable tests for RESTful APIs, enabling you to write powerful code for testing complex scenarios with minimal effort.

In this tutorial, we'll start with a simple test using RestAssured with the website `https://reqres.in/api/`.

### Simple Test Example with https://reqres.in/api/

```java
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SimpleTest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/api";

        given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }
}
```

## Explanation of `given()`, `when()`, and `then()`

RestAssured's syntax is influenced by BDD frameworks. Here’s a brief overview:

- **`given()`:** This method prepares the request. It's used to set up request data, headers, cookies, and other
  prerequisites before sending the request.

- **`when()`:** This encapsulates actions to send the request to the server. Methods like `get()`, `post()`, `put()`,
  `delete()`, etc., are invoked here.

- **`then()`:** This method deals with assertions to validate the response from the server. Assertions like
  `statusCode()`, checks on headers, body, etc., are defined here.

## Advanced Topics

### Anonymous JSON Root Validation

When you do not want to define a root path for your JSON response, you can perform anonymous root validation:

```java
given()
    .when()
        .get("/users/3")
    .then()
        .body("", hasKey("data"));  // Anonymous root validation  // Anonymous root validation
```

### Floats and Doubles

When dealing with floating points in JSON responses, use tolerance in your assertions due to precision issues:

```java
given()
    .when()
        .get("/financials")
    .then()
        .body("balance", closeTo(100.0, 0.01));
```

### Specifying the Request Method

Explicitly specifying the request method helps in clarity and makes the code flexible for enhancements:

```java
given()
    .request("GET", "/users/4")
    .then()
        .assertThat()
        .statusCode(200);
```

### Default Values Configuration

Configure default values to avoid repetition. It simplifies the tests and makes them more readable:

```java
RestAssured.baseURI ="https://reqres.in/api";
RestAssured.port =443;
```

### Measure and Validate Response Time

Ensure your API responses adhere to performance requirements:

```java
long timeInMs = given()
        .when()
        .get("/users")
        .time();

assertTrue(timeInMs < 1000);
```

### XML Response Verification

When dealing with XML responses, you can verify nodes and attributes:

```java
given()
    .when()
        .get("/xmlEndpoint")
    .then()
        .body("company.name", equalTo("Rest-Assured"));
```

### XPath for XML

XPath can be used for detailed verification in XML structures:

```java
given()
    .when()
        .get("/xmlData")
    .then()
        .body(hasXPath("/users/user[id='10']/firstName", equalTo("John")));
```

### Logging Test Details

Logging is critical for debugging. Log requests and responses easily:

```java
given()
    .log().all()
    .when()
        .get("/users/5")
    .then()
        .log().body();
```

## Conclusion

RestAssured provides a robust set of tools to handle a variety of testing needs for RESTful services. As you delve
deeper into its features, you'll find it invaluable for API testing, leading to more reliable and maintainable tests.
Equip yourself with the understanding of these features and use them to ensure thorough testing of all your API
endpoints. Happy testing!