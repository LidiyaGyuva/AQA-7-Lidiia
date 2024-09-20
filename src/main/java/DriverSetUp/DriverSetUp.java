package DriverSetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverSetUp {
    private static WebDriver driver;
    private static WebDriver setUpDriver2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-gpu");
        //options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;

    }
    private static WebDriver getInstance(){
        if (driver == null){
            try{
                driver = setUpDriver2();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        return driver;
    }

    public static WebDriver startDriver(){
        driver = getInstance();
        return driver;
    }

}
