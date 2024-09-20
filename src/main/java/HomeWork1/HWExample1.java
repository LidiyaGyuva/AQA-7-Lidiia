package HomeWork1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*Написать программу, которая будет открывать четыри различных страниц в новых окнах:
https://zoo.kiev.ua/
https://www.w3schools.com/
https://taxi838.ua/ru/dnepr/
https://klopotenko.com/

Прописать цикл, который будет переключаться поочередно через все страницы,
для каждой страницы выводить в консоль название и ссылку на эту страницу.
И будет закрывать ту страницу в названии которой есть слово зоопарк.*/

public class HWExample1 {
    public static void openLinkInNewTab(WebDriver driver, String url) {
        Set<String> set1 = driver.getWindowHandles();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String windowDescriptor2 = set2.iterator().next();
        driver.switchTo().window(windowDescriptor2);
        driver.get(url);

    }
        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = DriverSetUp.setUpDriver();
            driver.get("https://zoo.kiev.ua/");
            openLinkInNewTab(driver, "https://www.w3schools.com/");
            openLinkInNewTab(driver, "https://taxi838.ua/ru/dnepr/");
            openLinkInNewTab(driver, "https://klopotenko.com/");


            List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

            for (String windowHandle : windowHandles) {
                driver.switchTo().window(windowHandle);

                String title = driver.getTitle();
                String url = driver.getCurrentUrl();
                System.out.println("Название: " + title);
                System.out.println("Ссылка: " + url);

                if (title.toLowerCase().contains("зоопарк")) {
                    driver.close();  // Закрываем окно, если в названии есть "зоопарк"
                }
            }

Thread.sleep(2000);
            driver.quit();

        }

}
