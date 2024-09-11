package HomeWork_3;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.management.Descriptor;
import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OpenSite {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();

        //step 1 = open all site
        driver.get("https://www.google.com/search");
        Set<String> set1 = driver.getWindowHandles();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
//open guinness
        WebElement searchElement = driver.findElement(By.xpath("//textarea[@title='Поиск']"));
        searchElement.sendKeys("https://www.guinnessworldrecords.com/account/register");
        driver.findElement(By.xpath("//textarea[@title='Поиск']")).sendKeys(Keys.ENTER);
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='https://www.guinnessworldrecords.com/account/register']"))).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String windowDescriptor2 = set2.iterator().next();
        driver.findElement(By.xpath("//span[@class=\"ExCKkf z1asCe rzyADb\"]")).click();
        //open hyrtutorial site
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("//https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(Keys.ENTER);
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='https://www.hyrtutorials.com/p/alertsdemo.html'][@jsname='UWckNb']"))).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        Set<String> set3 = driver.getWindowHandles();
        //open w3schools.com
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");


        //step 2 = work in w3schools.com
        try {
            driver.findElement(By.id("accept-choices")).click();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        driver.switchTo().frame("iframeResult");
        WebElement nameElement = driver.findElement(By.xpath("//input[@value='John']"));
        nameElement.clear();
        nameElement.sendKeys("Lidiia");
        WebElement lastName = driver.findElement(By.xpath("//input[@value='Doe']"));
        lastName.clear();
        lastName.sendKeys("Tukalenko");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        System.out.println("=========");
        System.out.println();
        System.out.println(driver.findElement(By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']")).getText());
        driver.switchTo().window(windowDescriptor2);
        //step 3 = work in second window
        actions.moveToElement(driver.findElement(By.xpath("//input[@name='lastName']"))).click().sendKeys("Lidiia").moveToElement(driver.findElement(By.xpath("//input[@name='firstName']"))).click().sendKeys("Tucalenko").build().perform();
       driver.findElement(By.xpath("//input[@type='date']")).sendKeys("09091994");
        driver.findElement(By.xpath("//div[@aria-haspopup='listbox'][@aria-labelledby='country-label country-label']")).click();
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(), 'United Arab Emirates')]"))).click().build().perform();

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='MuiFormControl-root MuiTextField-root css-i44wyl']"))).click().sendKeys("Kyiv").perform();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mailmail@gmail.com");
        driver.findElement(By.xpath("//input[@name='confirmEmail']")).sendKeys("mailmail@gmail.com");

        driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'][@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'][@name='confirmPassword']")).sendKeys("54321");
        WebElement countryElement = driver.findElement(By.id("countyState"));
        countryElement.sendKeys("Kyiv");

        //ТОГО повідомлення, що в ТЗ, ніяким способом не дістати, тож цю перевірку зробити не можу

        //step 4 = work in third window
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String firstWindow = iterator.next();  // Первое окно
        String secondWindow = iterator.next(); // Второе окно
        String thirdWindow = iterator.next();  // Третье окно
        driver.switchTo().window(thirdWindow);
        System.out.println("======================");
        System.out.println();

    driver.findElement(By.xpath("//button[@onclick='alertFunction()']")).click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());

    driver.findElement(By.xpath("//button[@onclick='confirmFunction()']")).click();
    alert.dismiss();
    System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());

    driver.findElement(By.xpath("//button[@onclick='promptFunction()']")).click();
    alert.sendKeys("Final step of this task");
    alert.dismiss();
    System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());
    driver.quit();





    }
}
