package All_Practics.Practics.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CeleniumClass {
    public static void main(String[] args) throws InterruptedException {

    /*    //запомнить эту часть, так как это путь к нашему тестовому браузеру
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //тут путь к браузеру заканчивается, дальше мы указываем сайт и действия

        driver.get("https://www.google.com/"); //відкрити сайт
        Thread.sleep(2000); //чекаємо
        driver.quit(); //закрыть браузер
*/

        WebDriverManager.chromedriver().clearDriverCache().setup(); // прямое подключение к тестовому браузеру

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/"); //відкрити сайт



    }
}
