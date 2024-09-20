package Lesson8.pRACTIC._dependens.test;


import HomeWork_3.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependenceTest {
    static WebDriver driver;

    public DependenceTest() {
    }

    @BeforeClass
    public void setUpDriver() {
        driver = DriverSetUp.setUpDriver();
    }

    @AfterClass
    public void killDriver() {
        driver.quit();
    }

    @Test
    public void a() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }

    @Test(
            enabled = false
    )
    public void b() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }

    @Test
    public void c() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }

    @Test
    public void k() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }

    @Ignore
    @Test
    public void q() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }

    @Test
    public void d() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }

    @Test(
            dependsOnMethods = {"a", "b"},
            alwaysRun = true
    )
    public void f() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }
}

