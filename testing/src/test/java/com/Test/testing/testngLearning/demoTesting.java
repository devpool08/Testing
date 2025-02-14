package com.Test.testing.testngLearning;

import org.testng.annotations.*;

public class demoTesting {
    @BeforeClass
    void beforeClass() {
        System.out.println("beforeClass successful");
    }

    @BeforeMethod
    void setup() {
        System.out.println("setup successful");
    }

    @Test(priority = 2)
    void test(){
        System.out.println("test successful");
    }

    @Test(priority = 3)
    void test2(){
        System.out.println("test2 successful");
    }

    @Test(priority = 1)
    void test3(){
        System.out.println("test3 successful");
    }

    @Test(priority = 4)
    void test4(){
        System.out.println("test4 successful");
    }

    @Test(priority = 5)
    void test5(){
        System.out.println("test5 successful");
    }
    @AfterMethod
    void teardown() {
        System.out.println("teardown successful");
    }
    @AfterClass
    void afterClass() {
        System.out.println("afterClass successful");
    }
}
