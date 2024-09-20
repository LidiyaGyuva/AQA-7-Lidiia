package All_Practics.Practic250224;

import HomeWork1.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetcaPractic {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://rozetka.com.ua/");
     // click login = (//button[@class = 'header__button ng-star-inserted'])[1]
     driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[3]/rz-user/button")).click();
// /html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[3]/rz-user/button
        //(//button[@class = 'header__button ng-star-inserted'])[1])
        Thread.sleep(1500);
     driver.findElement(By.id("auth_email")).sendKeys("Login");
     driver.findElement(By.id("auth_pass")).sendKeys("Password");
        Thread.sleep(1500);
     driver.findElement(By.xpath("//label[@class = 'auth-modal__remember-checkbox']")).click();
     Thread.sleep(1500);
     String textForElement = driver.findElement(By.xpath("/html/body/app-root/rz-single-modal-window/div[3]/div[2]/rz-user-identification/rz-auth/div/form/fieldset/div[5]/button[2]")).getText();
        System.out.println(textForElement);

     driver.quit();



    }
}
