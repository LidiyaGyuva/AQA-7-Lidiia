package Lesson8.pRACTIC;

import HomeWork1.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MyTestLIDIIA {

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
        public void myFirstClass () {

            driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
            String textForSending = "Handstand";
            new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.xpath("//input[@name='publicSearchBar']")).sendKeys(textForSending);
            Assert.assertTrue(driver.findElement(By.xpath("//input[@name='publicSearchBar']")).isDisplayed());
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.tagName("h2"));
            System.out.println();
            Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains(textForSending), "The test is failed");
            Assert.assertFalse(driver.findElement(By.tagName("h2")).getText().contains("textForSending"), "The test is failed");
            Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
            //Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");  NOT EQUALS

            //єто уже тестовый метод который мы можем запустить
        }

    @Test
    public void mySecondClass () {

        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        String textForSending = "Handstand";
        new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.xpath("//input[@name='publicSearchBar']")).sendKeys(textForSending);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='publicSearchBar']")).isDisplayed());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.tagName("h2"));
        System.out.println();
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains(textForSending), "The test is failed");
        Assert.assertFalse(driver.findElement(By.tagName("h2")).getText().contains("textForSending"), "The test is failed");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
        //Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");  NOT EQUALS

        //єто уже тестовый метод который мы можем запустить
    }

    }

