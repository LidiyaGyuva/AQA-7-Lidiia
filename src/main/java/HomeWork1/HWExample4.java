package HomeWork1;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

public class HWExample4 {

    /*4)
Написать программу, которая повторит действия на видео “HW_AUTOMATION_LESSON_3_UPDATE.mp4”.
http://www.automationpractice.pl/index.php*/

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        //ищем платье
        WebElement inputElement1 = driver.findElement(By.id("search_query_top"));
        inputElement1.sendKeys("Printed Chiffon Dress");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        driver.findElement(By.xpath("//a[@title='Printed Chiffon Dress'][@class='product-name']")).click();
WebElement selectElements = driver.findElement(By.id("group_1"));
//выбираем размер и добавляем в корзину
        Select dress = new Select(selectElements);
        dress.selectByVisibleText("M");
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();
        Thread.sleep(2000);
        WebElement clickElement = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
        clickElement.click();

        //раздел вумен, ищем футболку
        driver.findElement(By.xpath("//a[@class='sf-with-ul'][@title='Women']")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Faded short");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts'][@class='product-name']")).click();
        WebElement selectElement2 = driver.findElement(By.id("group_1"));
        Select tShort = new Select(selectElement2);
        tShort.selectByVisibleText("M");
        driver.navigate().refresh();
        //согласно ТЗ тут невозможно добавить футболку в корзину, поэтому я заменяю одежду для добавления

        driver.findElement(By.xpath("//a[@class='sf-with-ul'][@title='Women']")).click();
        driver.findElement(By.xpath("//a[@class='product-name'][@title='Blouse']")).click();
        WebElement colorElement = driver.findElement(By.id("group_1"));
        Select color = new Select(colorElement);
        color.selectByValue("3");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();
        WebElement clickElementToo = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();


        Thread.sleep(3000);
        driver.quit();

    }

}
