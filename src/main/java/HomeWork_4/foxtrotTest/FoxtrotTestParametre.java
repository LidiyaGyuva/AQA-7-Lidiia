package HomeWork_4.foxtrotTest;

import HomeWork_4.DriverSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FoxtrotTestParametre {
    static WebDriver driver;

    public FoxtrotTestParametre() {
    }

    @BeforeClass
    public void setUpDriver() {
        driver = DriverSetUp.setUpDriver();
    }

    @AfterClass
    public void killDriver() {
        driver.quit();
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

    @Test(
            dataProvider = "wordSearch"
    )
    public static void Search(String word) {
        driver.get("https://www.foxtrot.com.ua/");
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(new CharSequence[]{word});
        driver.findElement(By.xpath("//input[@class='header-search__button evinent-search-button']")).click();

        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page__title']")).getText().contains(word), "Слово = " + word + " = не було знайдено.");
        } catch (Exception var2) {
            System.out.println(var2.getMessage());
        }

    }

    @DataProvider(
            name = "wordSearch"
    )
    public Object[][] createData() {
        return new Object[][]{{"машина"}, {""}, {"input"}, {""}, {"розуміння"}, {""}};
    }
}
