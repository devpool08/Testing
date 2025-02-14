package com.Test.testing.testngLearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class demo2Testing {
    @Test
    public void testMethod1() {
        System.out.println("Test2 successful");
    }

    @Test
    public void testMethod2() {
        Assert.assertEquals(2,2);
    }
}
