[//]: # (all ok)

---

# TestNG Overview

TestNG is a testing framework designed to simplify a broad range of testing needs, from unit testing to integration
testing. It provides a more powerful and flexible testing framework compared to JUnit, particularly through its support
for parameterized and parallel testing.

## Requirements

- Java Development Kit (JDK) - Java 8 or higher.
- An integrated development environment (IDE) like IntelliJ IDEA.
- Maven or Gradle (for managing dependencies, though you could also configure the build manually).

## Dependencies

To use TestNG with Maven, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.4.0</version>
    <scope>test</scope>
</dependency>
```

For Gradle, add this dependency in your `build.gradle`:

```groovy
dependencies {
    testImplementation 'org.testng:testng:7.4.0'
}
```

## Setup in IntelliJ IDEA

Follow these steps to set up TestNG in IntelliJ IDEA:

1. **Create a new Maven or Gradle project**:
    - Open IntelliJ IDEA.
    - Click `File > New > Project`.
    - Choose Maven or Gradle on the left panel, specify JDK for the project, and complete the project setup wizard.

2. **Add TestNG Dependency**:
    - For Maven, modify the `pom.xml` as shown above.
    - For Gradle, update the `build.gradle` file.

3. **Enable Annotation Processing** (Important for TestNG to work correctly):
    - Go to `File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors`.
    - Check `Enable annotation processing`.

4. **Create a testNG.xml file**:
    - Right-click on your project or module, go to `New > File` and name it `testNG.xml`. Configure it as per your test
      requirements.

5. **Create/Test a TestNG class**:
    - Right-click on `src/test/java`, go to `New > Java Class` and name your test class.
    - Use annotations like `@Test` from `org.testng.annotations.Test` to signify test methods.

6. **Run Tests Using testNG.xml**:
    - Right-click on the `testNG.xml` file and select `Run` from the context menu to execute all tests defined in the
      file.

### IntelliJ IDEA Configuration Tip

If you encounter issues with running TestNG tests or configurations, ensure you have the correct TestNG plugin enabled:

- Go to `File > Settings > Plugins` and search for TestNG. Ensure it's installed and enabled.

## testNG.xml File

The `testNG.xml` file allows you to configure and manage your testing suite. Refer to the earlier section in this
document for a detailed guide on the structure and contents of this file.

By following these guidelines, you should be able to set up TestNG in IntelliJ IDEA and start creating and running your
tests. Happy testing!

---

# TestNG Overview

TestNG is a testing framework designed to simplify a broad range of testing needs, from unit testing to integration
testing. One of the core features of TestNG is its flexibility which comes from the XML test configuration files (
testNG.xml). These XML files allow testers to configure and manage their test suites with ease.

## testNG.xml File

The testNG.xml file is crucial for running TestNG tests. It is an XML file that specifies the test configurations,
controlling various aspects of how your tests are run.

### Contents of testNG.xml

The testNG.xml file typically includes the following key elements:

- **`<suite>`**: Represents a suite of tests. It can include one or more `<test>` tags.

- **`<test>`**: Represents a group of test classes. It can contain one or more `<classes>` tags.

- **`<classes>`**: Contains the `<class>` tags, specifying the test classes to be executed.

- **`<class>`**: Specifies a test class that contains test methods.

- **`<methods>`**: Optionally include specific methods to be executed, within a `<class>`.

- **`<groups>`**: Allows defining or specifying groups of tests and methods for selective test execution.

- **`<parameters>`**: Facilitates passing parameters to test methods.

- **`<listeners>`**: Specifies TestNG listeners like `IInvokedMethodListener`, `ITestListener`, etc.

### Example testNG.xml

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="SampleTestSuite">
    <test name="SampleTest">
        <classes>
            <class name="com.example.tests.TestClass1"/>
            <class name="com.example.tests.TestClass2">
                <methods>
                    <include name="testMethod1"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>
```

### Execution of testNG.xml

To execute tests using a testNG.xml file, follow these steps:

1. **Create testNG.xml**: Define your test suites, tests, classes, and optionally methods in the XML file as shown
   above.

2. **Run testNG.xml**:
    - If using an IDE like Eclipse or IntelliJ, right-click on the testNG.xml file and select "Run As > TestNG Suite".
    - If using the command line, navigate to your project directory and run the following command:
      ```bash
      java -cp "path-to-testng.jar:path-to-your-compiled-classes" org.testng.TestNG testng.xml
      ```

TestNG.xml provides a powerful way to manage and configure your tests with ease, ensuring comprehensive and flexible
test execution.

For further details or advanced configurations, refer to the
official [TestNG Documentation](https://testng.org/doc/documentation-main.html).

---
Certainly! Below is a sample `README.md` that explains TestNG annotations which are pivotal for structuring TestNG
tests.

---

# TestNG Annotations Overview

TestNG (Test Next Generation) is a powerful testing framework used in Java to cover all types of tests including unit,
functional, end-to-end, integration, etc. Annotations in TestNG are a way to control the flow of test execution. This
document outlines various TestNG annotations and how they are used in creating test cases.

## Common TestNG Annotations

### **1. `@Test`**

This is the most basic and commonly used TestNG annotation which signals that the method annotated is a test method.

Example:

```java
@Test
public void exampleTest() {
    // test code
}
```

### **2. `@BeforeSuite`**

Executed before all tests in the suite are run. This is generally used for initializing web drivers, setting up DB
connections, etc.

Example:

```java
@BeforeSuite
public void beforeSuiteSetup() {
    // setup code
}
```

### **3. `@AfterSuite`**

Executed after all tests in the suite have been run. This is generally used for cleanup activities.

Example:

```java
@AfterSuite
public void afterSuiteCleanup() {
    // cleanup code
}
```

### **4. `@BeforeTest`**

Executed before each `<test>` tag in the testNG.xml.

Example:

```java
@BeforeTest
public void beforeTestSetup() {
    // setup code
}
```

### **5. `@AfterTest`**

Executed after each `<test>` tag in the testNG.xml.

Example:

```java

@AfterTest
public void afterTestCleanup() {
    // cleanup code
}
```

### **6. `@BeforeClass`**

Executed before the first method of the current class is invoked.

Example:

```java
@BeforeClass
public void beforeClassSetup() {
    // setup code
}
```

### **7. `@AfterClass`**

Executed after all the test methods of the current class have been tested.

Example:

```java

@AfterClass
public void afterClassCleanup() {
    // cleanup code
}
```

### **8. `@BeforeMethod`**

Executed before each test method.

Example:

```java
@BeforeMethod
public void beforeMethodSetup() {
    // setup code
}
```

### **9. `@AfterMethod`**

Executed after each test method.

Example:

```java
@AfterMethod
public void afterMethodCleanup() {
    // cleanup code
}
```

### **10. `@Parameters`**

Used for passing parameters to tests from testNG.xml.

Example:

```java
@Test
@Parameters("testParam")
public void parameterizedTest(String testParam) {
    System.out.println("Parameterized value is : " + testParam);
}
```

### **11. `@DataProvider`**

This annotation is used for providing data to test methods. It must return an array of objects.

Example:

```java
@DataProvider(name = "data-provider")
public Object[][] dataProviderMethod() {
    return new Object[][]{{"Array 1"}, {"Array 2"}};
}

@Test(dataProvider = "data-provider")
public void testMethod(String data) {
    System.out.println("Data is: " + data);
}
```

## Conclusion

TestNG annotations are critical for managing test execution flow and also for parameterizing tests, cleaning up after
tests, running preconditions, etc. Each annotation serves a specific purpose, making TestNG a powerful and flexible
framework for testing.

By understanding and effectively using these annotations, you can significantly enhance your testing framework and
ensure comprehensive testing coverage.

Certainly! Below is a comprehensive `README.md` file that addresses the concept of groups in TestNG, their purpose, how
to define and use them, and the various types.

---

# TestNG Groups Overview

TestNG allows defining groups to organize tests more efficiently and to execute a select set of tests among many. By
grouping tests, you can easily manage the test execution of different sets of tests based on features, modules,
functionality, etc.

## What is a Group in TestNG?

Groups in TestNG are simply a way to bundle multiple test methods into a named group. This is particularly useful when
you want to run only a subset of tests from a larger test suite.

## The Need for Groups

- **Selective Testing**: Run tests selectively based on features, bug fixes, environments, etc.
- **Organization**: Better organization of tests especially in large test suites.
- **Dependency Management**: Manage dependencies between tests, ensuring that certain tests run only after specific
  groups have finished executing.
- **Access Control**: Specify different groups for different accessibility, like smoke, regression, or integration
  tests.

## Steps to Define Groups

To define and use groups in TestNG, follow these steps:

### 1. Tag Test Methods with Groups

You can associate a test method with one or more groups using the `groups` attribute in the `@Test` annotation.

Example:

```java
@Test(groups = {"login"})
public void testLogin() {
    // code
}

@Test(groups = {"logout"})
public void testLogout() {
    // code
}

@Test(groups = {"navigation", "smoke"})
public void testNavigate() {
    // code
}
```

### 2. Configure testNG.xml to Run Specific Groups

Modify your `testNG.xml` file to specify which groups should be included or excluded during the test run.

Example:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="TestSuite">
    <test name="SmokeTest">
        <groups>
            <run>
                <include name="smoke"/>
            </run>
        </groups>
        <classes>
            <class name="com.example.tests.NavigationTests"/>
        </classes>
    </test>
</suite>
```

## Types of Groups

In TestNG, groups can be categorized in various ways based on their use:

- **Module-based Groups**: Organizing tests based on the module they are testing.
- **Functionality-based Groups**: Grouping based on functionalities like CRUD operations.
- **Regression Groups**: Includes all the tests required for regression testing.
- **Smoke Groups**: Critical tests which must pass for any further testing to proceed.

## Executing Groups

### At Different Levels

#### Suite Level

In `testNG.xml`, groups can be included or excluded at the suite level allowing selective testing across multiple
classes.

Example:

```xml
<suite name="Suite">
    <groups>
    <define name="all">
        <include name="smoke"/>
        <include name="regression"/>
    </define>
    </groups>
    <test name="FunctionalTests">
        <groups>
            <run>
                <include name="all"/>
            </run>
        </groups>
        <classes>
            <class name="com.example.tests.SampleTest"/>
        </classes>
    </test>
</suite>
```

#### Class Level

You can also specify group inclusion or exclusion at the class level in `testNG.xml`.

Example:

```xml

<test name="LoginTests">
    <classes>
        <class name="com.example.tests.Login">
            <methods>
                <include name="login"/>
            </methods>
        </class>
    </classes>
</test>
```

## Conclusion

Groups in TestNG allow for highly flexible test executions and are integral for managing large test suites effectively.
They help ensure that tests related to specific functionalities can be easily and selectively executed, which is
invaluable for agile and continuous integration environments.

Certainly, here's a `README.md` file detailing the key differences between TestNG and JUnit, particularly focusing on
specific features such as test configuration, annotations, dependency handling, parallel execution, data-driven testing,
reporting, and priority management.

---

# TestNG Listeners Overview

Listeners in TestNG are an essential feature that allows monitoring the execution of tests and taking action based on
various events. These listeners can be implemented to modify TestNG’s behavior and output, making them powerful tools in
building flexible and robust test suites.

## What is a Listener in TestNG?

A Listener in TestNG is essentially an interface that can be implemented to execute blocks of code at various points
within the test execution cycle, such as before, during, or after a test is run. It listens to the event defined in the
interface and executes code based on those events.

## The Need for Listeners

- **Custom Logging**: To generate custom logs or reports.
- **Failure Handling**: Executing recovery scenarios or additional tests upon failures.
- **Notification**: Sending emails or messages when certain conditions are met during test executions.
- **Dynamic Configuration**: Modifying the test configuration before executing the tests.
- **Debugging**: More detailed insights into the test flow and behavior, which can assist in debugging.

## Types of Listeners in TestNG

TestNG provides several listeners by default, and each can be implemented according to the needs of your testing
framework. Some of the key listeners include:

### 1. `ITestListener`

It deals with basic events like on test start, on test success, on test failure, etc.

### 2. `ISuiteListener`

Trigger actions when a TestNG suite starts and ends.

### 3. `IReporter`

For advanced reporting capabilities—listeners that implement this interface can create logs or reports in various
formats after the tests are completed.

### 4. `IInvokedMethodListener`

Responds to every method that is invoked in your test, providing a powerful tool to perform certain actions before and
after every test method.

### 5. `IAnnotationTransformer`

Modifies TestNG annotations dynamically.

## Using Listeners in Different Levels

Listeners can be added in different scopes:

### **Global Level**

Using the `@Listeners` annotation at the class or suite level:

```java

@Listeners({CustomListener.class})
public class SampleTest {
    // test methods
}

```

### **Suite/Test Level in testng.xml**

Listeners can also be defined in the `testng.xml` configuration file:

```xml

<suite name="Suite1">
    <listeners>
        <listener class-name="com.example.CustomListener"/>
    </listeners>
    <test name="Test1">
        <classes>
            <class name="com.example.tests.SampleTest"/>
        </classes>
    </test>
</suite>

```

## Difference Between Listeners and Annotations

While both listeners and annotations allow you to execute code at different stages of the test execution, they serve
different purposes:

- **Listeners**: Provide a global way to trigger actions across multiple tests and are configurable in the test suite
  itself. They are powerful for executing logic across multiple points of the test cycle and are detached from the test
  code itself.

- **Annotations**: Are used to configure specific tests or set up and tear down methods directly within the test
  classes. They directly interact with the test methods and are visibly part of the test code.

Listeners offer more flexibility in managing cross-cutting concerns without cluttering the test code, while annotations
provide a straightforward way to manage test flow and configuration.

## Conclusion

Listeners in TestNG are powerful tools for enhancing and customizing the execution and reporting of tests. By
implementing these listeners, you can create a more responsive, robust, and tailor-made testing framework that aligns
with your specific requirements.

As you expand your testing framework, consider the strategic use of listeners to simplify complex testing scenarios,
enforce additional logic, and generate detailed reports.

--- 
Certainly! Below is a `README.md` file to help explain the concept of assertions in TestNG, their necessity, and how to
implement different types of assertions.

---

# TestNG Assertions Overview

Assertions in TestNG are a set of methods that are used in the scripting of test cases to compare the actual outcome of
the test against the expected outcome. They are fundamental to unit testing because they help validate that the test
conditions are met.

## What is an Assertion in TestNG?

An assertion is essentially a Boolean expression that the program checks as true or false. If the expression evaluates
to true, the test and the program continue executing. If it evaluates to false, the framework throws an AssertionError,
and the test is considered failed.

## The Need for Assertions

- **Validation**: Assertions help validate the code behaves as expected.
- **Quality Assurance**: Proper use of assertions improves the quality and reliability of the automation test cases.
- **Immediate Feedback**: They provide immediate feedback on the failure, which is crucial for CI/CD processes.
- **Stop Execution**: When critical failures are detected, further test execution can be unnecessary or misleading, and
  assertions can halt this.

## Implementing Different Types of Assertions

TestNG provides a rich set of assertion methods through the `Assert` class. Here are some commonly used assertions and
how to implement them:

### 1. `assertEquals`

Asserts that two values are equal. If they are not, an AssertionError is thrown.

```java

@Test
public void testEquality() {
    Assert.assertEquals("Hello", "Hello", "Optional failure message");
}
```

### 2. `assertTrue` and `assertFalse`

Asserts that a condition is true or false.

```java

@Test
public void testCondition() {
    boolean condition = true;
    Assert.assertTrue(condition, "Condition is not true");
}
```

```java

@Test
public void testFalseCondition() {
    boolean condition = false;
    Assert.assertFalse(condition, "Condition is not false");
}
```

### 3. `assertNotNull` and `assertNull`

Checks if an object is null or not.

```java

@Test
public void testNotNull() {
    Object obj = new Object();
    Assert.assertNotNull(obj, "Object is null");
}

```

### 4. `assertSame` and `assertNotSame`

Checks if two references point to the exact same object or not.

```java

@Test
public void testSame() {
    Integer num1 = 127;
    Integer num2 = 127;
    Assert.assertSame(num1, num2, "num1 and num2 do not refer to the same object");
}

```

### 5. `assertArrayEquals`

Checks whether two arrays are equal to each other or not.

```java

@Test
public void testArrayEquality() {
    int[] expectedArray = {1, 2, 3};
    int[] resultArray = {1, 2, 3};
    Assert.assertArrayEquals(expectedArray, resultArray, "Arrays are not equal");
}

```

## Conclusion

Assertions are a key component of any testing framework as they provide a means to validate the behavior and outcome of
the tests. In TestNG, the `Assert` class offers a comprehensive list of methods to implement assertions effectively
which helps increase the robustness of your test cases.

By integrating these assertions properly into your tests, you can ensure that your code not only works but is reliable
and maintains intended functionality over time.

---

# TestNG Parallel Execution Overview

Parallel execution in testing refers to the ability to run multiple test methods or test classes simultaneously. This
feature is crucial in reducing the time required to run large test suites and is especially beneficial in a continuous
integration environment.

## What is Parallel Execution in Testing?

Parallel execution involves running multiple tests or several parts of a test at the same time to minimize the overall
execution time. In the context of automated testing with TestNG, parallel execution allows multiple tests to run
concurrently, making it a vital feature for expediting test cycles.

## The Need for Parallel Execution

- **Faster Test Execution**: Significantly reduces the time taken to run extensive test suites.
- **Better Resource Utilization**: Makes efficient use of available hardware resources by distributing tests across
  available CPU cores.
- **Increased Test Throughput**: Handles more test cases in the same or less amount of time, which is critical in Agile
  and DevOps practices.
- **Feedback Loop**: Quicker feedback on the health of the application as tests finish sooner.

## Implementing Different Types of Parallel Execution in TestNG

TestNG provides multiple ways to configure parallel test execution through the `testng.xml` configuration file. Here are
the common parallel modes you can set via the `parallel` attribute on the `<suite>` or `<test>` tag:

### 1. Parallel Methods

This configuration will run all your test methods in separate threads.

**Example `testng.xml` Configuration**:

```xml

<suite name="Suite" parallel="methods" thread-count="5">
    <test name="Test">
        <classes>
            <class name="com.example.tests.SampleTestClass"/>
        </classes>
    </test>
</suite>

```

### 2. Parallel Classes

Enables TestNG to run all methods in the same class in the same thread, but each class will run in a separate thread.

**Example `testng.xml` Configuration**:

```xml

<suite name="Suite" parallel="classes" thread-count="3">
    <test name="Test">
        <classes>
            <class name="com.example.tests.FirstClass"/>
            <class name="com.example.tests.SecondClass"/>
        </classes>
    </test>
</suite>

```

### 3. Parallel Tests

Each `<test>` tag in the XML file runs in a separate thread.

**Example `testng.xml` Configuration**:

```xml

<suite name="Suite" parallel="tests" thread-count="2">
    <test name="LoginTests">
        <classes>
            <class name="com.example.tests.LoginTest"/>
        </classes>
    </test>
    <test name="SignUpTests">
        <classes>
            <class name="com.example.tests.SignUpTest"/>
        </classes>
    </test>
</suite>

```

### 4. Parallel Instances

Multiple instances of the same test class are executed in parallel threads.

**Example `testng.xml` Configuration**:

```xml

<suite name="Suite" parallel="instances" thread-count="4">
    <test name="InstanceTest">
        <classes>
            <class name="com.example.tests.InstanceTestClass"/>
        </classes>
    </test>
</suite>

```

## Conclusion

Parallel execution in TestNG can dramatically reduce the time taken for test execution, facilitate better resource
usage, and provide quicker feedback, all of which are crucial for agile development and frequent releases. Depending on
your specific test case requirements and machine capabilities, you should choose an appropriate parallel execution
strategy.

By leveraging the parallel execution capabilities of TestNG, you can ensure your testing strategy keeps pace with the
increasingly rapid development cycles of modern software projects.

---

# TestNG vs JUnit: A Comparative Study

TestNG and JUnit are both popular Java-based testing frameworks that facilitate test automation. However, they do
possess distinctive features and functionalities that set them apart. This document aims to outline the major
differences between TestNG and JUnit based on several criteria.

## Test Configuration

**TestNG**:

- TestNG utilizes XML files for test configuration, allowing you to manage test suites, test groups, and parameters
  externally.
- Provides more flexibility in configuring tests, suites, and groups.

**JUnit**:

- Prior to JUnit 5, there was no native support for external test configuration. JUnit 5 introduced `@TestFactory` for
  dynamic tests but still lacks the broad configurative approach of TestNG.
- Uses annotations primarily to handle configuration which is hard-coded in the test files.

## Test Annotations

**TestNG**:

- Offers a wide range of annotations like `@BeforeSuite`, `@BeforeTest`, `@BeforeClass`, `@BeforeMethod`, `@Test`,
  `@AfterMethod`, `@AfterClass`, `@AfterTest`, `@AfterSuite`.
- Annotations are straightforward and align naturally with different levels of testing.

**JUnit**:

- Uses annotations such as `@BeforeClass`, `@Before`, `@After`, `@AfterClass`, `@Test`.
- In JUnit 5, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll` are similar to TestNG but with slightly different
  nomenclature and usage.

## Dependency Management

**TestNG**:

- Provides native support for dependency testing with `dependsOnMethods` and `dependsOnGroups`.
- Allows you to specify execution order if a particular method depends on the result of another method.

**JUnit**:

- Dependency management isn't directly supported.
- Workarounds like method ordering can be managed in JUnit 5 but not as explicitly as in TestNG.

## Parallel Execution

**TestNG**:

- Strong support for parallel test execution including classes, methods, tests, etc., through simple XML configurations.
- Crucial for reducing execution time for large test suites.

**JUnit**:

- JUnit 5 supports parallel execution through its experimental API but requires additional configuration and isn't as
  seamlessly integrated as in TestNG.

## Data-driven Testing

**TestNG**:

- Native support for data-driven testing using `@DataProvider`.
- Allows easy integration with external data sources and parameterized execution of tests.

**JUnit**:

- JUnit 5 supports parameterized tests with `@ValueSource`, `@EnumSource`, `@MethodSource`, `@CsvSource`,
  `@CsvFileSource`, etc.
- Less straightforward compared to TestNG's `@DataProvider`.

## Reporting

**TestNG**:

- Offers extensive reporting capabilities that are extensible. Generates detailed HTML reports by default.
- Provides listeners (`IReporter`, `ITestListener`) to customize reporting further.

**JUnit**:

- Basic reporting capabilities but often augmented with third-party libraries like Allure or ExtentReports.
- JUnit does not provide as detailed reporting out-of-the-box as TestNG.

## Priority and Ordering

**TestNG**:

- Allows assigning priorities to test methods with `priority` attribute in the `@Test` annotation.
- Executing tests in a specific order is straightforward and controlled.

**JUnit**:

- JUnit 5 introduced `@TestMethodOrder` to order the execution of test methods. However, it's generally less flexible
  compared to TestNG's priority system.

## Conclusion

Both TestNG and JUnit have their strengths, and the choice often depends on specific project requirements, team
familiarity, and the complexity of test scenarios. TestNG tends to offer more comprehensive solutions out-of-the-box,
particularly for configurations, dependencies, and parallel executions, which might be crucial for more extensive and
enterprise-level projects. JUnit, albeit simpler and with fewer built-in features, offers ease of use and is widely
adopted in the community, especially suitable for simpler applications.

---
