package org.example.testNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.function.Supplier;

@Listeners(TestListiner.class)
class TestDemo {
    Supplier<String> demo = () -> "Hi";

    void throwError(){
        throw new ArithmeticException("Error occurred");
    }
}

public class TestNGBasic {
    TestDemo testDemo;

    @BeforeClass
    public void setUp() {
        System.out.println("Setting up TestNG Basic");
        testDemo = new TestDemo();
    }

    @Test
    public void testFirstTest() {
        System.out.println("Running first test");
    }

    @Test
    public void testSecondTest() {
        Assert.assertEquals((testDemo.demo).get().toLowerCase(), "hi");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testThirdTest() {
        testDemo.throwError();
    }

    @Test(dependsOnMethods = "testFirstTest")
    public void testFourthTest() {
        System.out.println("Running fourth test");
    }

    @Test(priority = 2)
    public void testFifthTest() {
        System.out.println("Running fifth test");
    }


    @AfterClass
    public void tearDown() {
        System.out.println("Tearing down TestNG Basic");
        testDemo = null;
    }

}
