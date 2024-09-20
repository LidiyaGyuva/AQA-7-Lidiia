package HomeWork_4.foxtrotTest;


import HomeWork_4.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FoxtrotTest {
    static WebDriver driver;

    public FoxtrotTest() {
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

