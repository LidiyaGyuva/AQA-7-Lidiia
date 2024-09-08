package All_Practics.Practics.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewSelenium {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //WebDriverManager.chromedriver().setup();
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.get("https://www.google.com/");

        /*WebDriverManager.chromedriver().setup();
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.get("https://www.google.com/");*/

        /*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(1500);
        try{
            driver.findElement(By.xpath("//div[text()='Принять все']")).click();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(1500);
        driver.quit();*/
    }
}
