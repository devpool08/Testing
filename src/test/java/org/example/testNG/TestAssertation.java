package org.example.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssertation {
    @Test
    public void testAssertTrue() {
        boolean condition = true;
        assert condition : "Condition should be true";
    }


    @Test
    public void testEquality() {
        Assert.assertEquals("Hello", "Hello", "Optional failure message");
    }

    @Test
    public void testNotEquals() {
        Assert.assertNotEquals("Hello", "World", "Optional failure message");
    }

    @Test
    public void testTrue() {
        Assert.assertTrue(true, "Optional failure message");
    }

    @Test
    public void testFalse() {
        Assert.assertFalse(false, "Optional failure message");
    }

    @Test
    public void testNull() {
        String str = null;
        Assert.assertNull(str, "Optional failure message");
    }

    @Test
    public void testNotNull() {
        String str = "Hello";
        Assert.assertNotNull(str, "Optional failure message");
    }

    @Test
    public void testSame() {
        Object obj1 = new Object();
        Assert.assertSame(obj1, obj1, "Optional failure message");
    }

    @Test
    public void testNotSame() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Assert.assertNotSame(obj1, obj2, "Optional failure message");
    }

}
