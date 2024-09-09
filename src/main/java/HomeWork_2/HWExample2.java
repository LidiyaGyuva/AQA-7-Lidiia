package HomeWork_2;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HWExample2 {
 /*   2) https://demo.guru99.com/test/drag_drop.html
    Написать программу, которая будет автоматизировать сценарий показанный на видео “Сценарий для автоматизии.mov”.
    После выполнения сценария на видео вывести в консоль теуст кнопки “Perfect!”*/

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(driver);
        //1 step
        actions.dragAndDrop(driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'][@id='fourth'])[1]")), driver.findElement(By.id("amt7"))).perform();
        //2 step
        actions.dragAndDrop(driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'][@id='fourth'])[2]")), driver.findElement(By.id("amt8"))).perform();
        //3 step
        actions.clickAndHold(driver.findElement(By.id("credit2"))).moveToElement(driver.findElement(By.id("bank"))).release().build().perform();
        //4 step
        actions.clickAndHold(driver.findElement(By.id("credit1"))).moveToElement(driver.findElement(By.id("loan"))).release().build().perform();
        WebElement element = driver.findElement(By.id("equal"));
        System.out.println(element.getText());

        Thread.sleep(3000);
        driver.quit();


    }


}
