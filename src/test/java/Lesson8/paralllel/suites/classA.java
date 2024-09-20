package Lesson8.paralllel.suites;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class classA {
    @Test
    public void a(){
        WebDriver driver = HomeWork1.DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
        driver.quit();
    }
    @Test
    public void b(){
        WebDriver driver = HomeWork1.DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
        driver.quit();
    }
    @Test
    public void c(){
        WebDriver driver = HomeWork1.DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
        driver.quit();
    }

    @Test
    public void k(){
        WebDriver driver =HomeWork1.DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
        driver.quit();
    }

    @Test
    public void q(){
        WebDriver driver = HomeWork1.DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
        driver.quit();
    }

}
