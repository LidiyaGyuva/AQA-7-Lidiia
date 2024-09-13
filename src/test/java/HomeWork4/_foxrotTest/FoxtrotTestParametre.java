package HomeWork4._foxrotTest;

import HomeWork_4.DriverSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FoxtrotTestParametre {
   static WebDriver driver;
    @BeforeClass
    public void setUpDriver(){
        driver = DriverSetUp.setUpDriver();
    }
    @AfterClass
    public void killDriver(){
        driver.quit();
    }

    @BeforeClass
    @Parameters({"browser"})
    public void preconditions(String browser){
        switch (browser){
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
    }




    @Test(dataProvider = "wordSearch")
    public static void Search(String word) {
        driver.get("https://www.foxtrot.com.ua/");
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(word);
        driver.findElement(By.xpath("//input[@class='header-search__button evinent-search-button']")).click();

        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page__title']")).getText().contains(word), "Слово = " + word + " = не було знайдено.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
    @DataProvider(name = "wordSearch")
    public Object[][] createData(){
        return new Object[][]{
                {"машина"},{""},
                {"input"},{""},
                {"розуміння"},{""},
        };
    }


}
