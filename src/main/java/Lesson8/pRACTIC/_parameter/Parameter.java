package Lesson8.pRACTIC._parameter;



import HomeWork_4.CustomWaiterClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
    static WebDriver driver;

    public Parameter() {
    }

    @BeforeClass
    @Parameters({"browser"})
    public void preconditions(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
        }

    }

    @AfterClass
    public void postConditions() {
        driver.quit();
    }

    @Test
    public void loginNegativeTest() {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        CustomWaiterClass wait = new CustomWaiterClass(driver);
        wait.waitForVisibilityOfElementLocated(By.id("email")).sendKeys(new CharSequence[]{"mail"});
        driver.findElement(By.id("passwd")).sendKeys(new CharSequence[]{"password"});
        driver.findElement(By.id("SubmitLogin")).click();
        wait.waitForVisibilityOfElementLocated(By.cssSelector(".alert.alert-danger p"));
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger p")).getText(), "There is 1 error");
    }
}

