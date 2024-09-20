package HomeWork_2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HWExample1 {
  /*  1) http://only-testing-blog.blogspot.com/2014/01/textbox.html?
    Написать программу реализующую действие показанное на “видео1.mp4”.
    После выполнения программы на консоли должна выводится информация в следующем виде:

    Автомобили доступные для выбора:
    Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
    Страны из первой таблицы:
    USA, Russia, Japan, Mexico, India, Malaysia, Greece.
    Страны из второй таблицы:
    France, Germany, Italy, Spain.*/

    public static void getInfo(WebDriver driver) {
        System.out.println("Автомобили доступные для выбора: " + driver.findElement(By.id("Carlist")).getText());
        System.out.println("Страны из первой таблицы: " + driver.findElement(By.xpath("//select[@name='FromLB']")).getText());
        System.out.println("Страны из второй таблицы: " + driver.findElement(By.xpath("//select[@name='ToLB']")).getText());

    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        // select car
        WebElement autoElement = driver.findElement(By.id("Carlist"));
        Select auto = new Select(autoElement);
        auto.selectByValue("Renault Car");

        //checkbox
        driver.findElement(By.id("check1")).click();
        driver.findElement(By.id("check2")).click();

       //country
        WebElement countryElement = driver.findElement(By.xpath("//select[@name='FromLB']"));
        Select selectCountry = new Select(countryElement);
        selectCountry.selectByVisibleText("France");
        selectCountry.selectByVisibleText("Germany");
        selectCountry.selectByVisibleText("Italy");
        selectCountry.selectByVisibleText("Spain");

        driver.findElement(By.xpath("//input[@value='->']")).click();

        //get Info
        getInfo(driver);

        Thread.sleep(3000);
        driver.quit();
    }

}
