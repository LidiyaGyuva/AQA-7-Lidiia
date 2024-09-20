package Lesson8.pRACTIC.dataProvider;


import HomeWork_3.DriverSetUp;
import HomeWork_4.CustomWaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
    static WebDriver driver;

    public DataProviderExample() {
    }

    @BeforeClass
    public void setUpDriver() {
        driver = DriverSetUp.setUpDriver();
    }

    @AfterClass
    public void killDriver() {
        driver.quit();
    }

    @Test(
            dataProvider = "loginParametrs"
    )
    public void loginNegativeTest(String mail, String password) {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        CustomWaiterClass wait = new CustomWaiterClass(driver);
        wait.waitForVisibilityOfElementLocated(By.id("email")).sendKeys(new CharSequence[]{mail});
        driver.findElement(By.id("passwd")).sendKeys(new CharSequence[]{password});
        driver.findElement(By.id("SubmitLogin")).click();
        wait.waitForVisibilityOfElementLocated(By.cssSelector(".alert.alert-danger p"));
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger p")).getText(), "There is 1 error");
    }

    @DataProvider(
            name = "loginParametrs"
    )
    public Object[][] createData() {
        return new Object[][]{{"invalid mail1", "invalid pass1"}, {"invalid mail2", "invalid pass2"}, {"invalid mail3", "invalid pass3"}, {"invalid mail4", "invalid pass4"}, {"invalid mail5", "invalid pass5"}};
    }
}

