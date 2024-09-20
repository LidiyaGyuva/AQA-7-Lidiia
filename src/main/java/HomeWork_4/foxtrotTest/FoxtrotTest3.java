package HomeWork_4.foxtrotTest;


import HomeWork_4.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FoxtrotTest3 {
    static WebDriver driver;

    public FoxtrotTest3() {
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
        boolean found = false;

        String searchBoxTitle;
        try {
            searchBoxTitle = driver.findElement(By.xpath("//div[@class='page__title']")).getText();
            if (searchBoxTitle.contains(word)) {
                found = true;
            }
        } catch (Exception var4) {
            System.out.println("Елемент по xpath не знайдено: " + var4.getMessage());
        }

        try {
            searchBoxTitle = driver.findElement(By.cssSelector(".search-page__box-title label")).getText();
            if (searchBoxTitle.contains(word)) {
                found = true;
            }
        } catch (Exception var3) {
            System.out.println("Елемент по cssSelector не знайдено: " + var3.getMessage());
        }

        Assert.assertTrue(found, "Слово = " + word + " = не було знайдено ні в одному з елементів.");
    }

    @DataProvider(
            name = "wordSearch"
    )
    public Object[][] createData() {
        return new Object[][]{{"машина"}, {""}, {"input"}, {""}, {"розуміння"}, {""}};
    }
}
