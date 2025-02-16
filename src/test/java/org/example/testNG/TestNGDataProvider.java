package org.example.testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Listeners(TestListiner.class)
public class TestNGDataProvider {
    List<Object[]> database;


    @BeforeClass
    public void setUp() {
        database = new ArrayList<>();
    }

    @DataProvider(name = "idDataProvider")
    public Object[] intProvider() {
        return new Object[]{1, 2, 3, 4, 5};
    }

    @DataProvider(name = "userDataProvider")
    public Object[][] getValidAccountData() {
        return new Object[][]{
                {"John Doe", "johndoe@example.com"},
                {"Jane Smith", "janesmith@example.com"},
                {"Bob Johnson", "bobjohnson@example.com"},
        };
    }

    @Test(dataProvider = "idDataProvider")
    public void testId(int id) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertTrue(list.contains(id), "Id Not Found");
    }

    @Test(dataProvider = "userDataProvider")
    public void testAddUser(String name, String email) {
        Assert.assertTrue(database.add(new Object[]{name, email}), "DataBase Error");
    }
    @Test(dataProvider = "userDataProvider")
    public void testUpdateUser(String name, String email) {
        boolean userFound = false;
        for (Object[] user : database) {
            if (user[0].equals(name) && user[1].equals(email)) {
                userFound = true;
                break;
            }
        }
        Assert.assertTrue(userFound, "User Not Found");
    }

}
