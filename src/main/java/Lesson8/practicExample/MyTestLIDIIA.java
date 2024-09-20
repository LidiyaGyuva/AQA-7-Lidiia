package Lesson8.practicExample;


import HomeWork1.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTestLIDIIA {
    static WebDriver driver;

    public MyTestLIDIIA() {
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
    public void myFirstClass() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        String textForSending = "Handstand";
        (new CustomWaiterClass(driver)).waitForVisibilityOfElementLocated(By.xpath("//input[@name='publicSearchBar']")).sendKeys(new CharSequence[]{textForSending});
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='publicSearchBar']")).isDisplayed());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        (new CustomWaiterClass(driver)).waitForVisibilityOfElementLocated(By.tagName("h2"));
        System.out.println();
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains(textForSending), "The test is failed");
        Assert.assertFalse(driver.findElement(By.tagName("h2")).getText().contains("textForSending"), "The test is failed");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }

    @Test
    public void mySecondClass() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        String textForSending = "Handstand";
        (new CustomWaiterClass(driver)).waitForVisibilityOfElementLocated(By.xpath("//input[@name='publicSearchBar']")).sendKeys(new CharSequence[]{textForSending});
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='publicSearchBar']")).isDisplayed());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        (new CustomWaiterClass(driver)).waitForVisibilityOfElementLocated(By.tagName("h2"));
        System.out.println();
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains(textForSending), "The test is failed");
        Assert.assertFalse(driver.findElement(By.tagName("h2")).getText().contains("textForSending"), "The test is failed");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }
}

