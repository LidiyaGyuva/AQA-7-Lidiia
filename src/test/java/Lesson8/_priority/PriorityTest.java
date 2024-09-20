package Lesson8._priority;

import HomeWork_3.DriverSetUp;
import Lesson8.pRACTIC.CustomWaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PriorityTest {
    static WebDriver driver;
    @BeforeClass
    public void setUpDriver(){
        driver = DriverSetUp.setUpDriver();
    }
    @AfterClass
    public void killDriver(){
        driver.quit();
    }

    @Test
    public void a(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");

    }
    @Test
    public void b(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");

    }
    @Test(priority = 2)
    public void c(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");

    }
    @Test(priority = 1)
    public void d(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");

    }
    @Test
    public void f(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");

    }
}
