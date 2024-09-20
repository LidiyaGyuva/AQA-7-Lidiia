package All_Practics;

import HomeWork1.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class TestMaiin {
    public static void main(String[] args) {
        // Укажите путь к драйверу Chrome

        WebDriver driver = DriverSetUp.setUpDriver();

        try {
            // Открываем первую страницу
            driver.get("https://zoo.kiev.ua/");
            String firstTab = driver.getWindowHandle();

            // Открываем остальные страницы в новых окнах
            openNewTab(driver, "https://www.w3schools.com/");
            openNewTab(driver, "https://taxi838.ua/ru/dnepr/");
            openNewTab(driver, "https://klopotenko.com/");

            // Получаем все открытые окна
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();

            // Переключаемся поочередно через все страницы
            while (iterator.hasNext()) {
                String windowHandle = iterator.next();
                driver.switchTo().window(windowHandle);

                // Получаем название и ссылку на страницу
                String title = driver.getTitle();
                String url = driver.getCurrentUrl();
                System.out.println("Название: " + title);
                System.out.println("Ссылка: " + url);

                // Проверяем, есть ли слово "зоопарк" в названии страницы
                if (title.toLowerCase().contains("зоопарк")) {
                    driver.close();  // Закрываем окно, если в названии есть "зоопарк"
                }
            }

            // Возвращаемся в исходное окно
            driver.switchTo().window(firstTab);

        } catch (WebDriverException e) {
            e.printStackTrace();
        } finally {
            // Закрываем все окна и завершаем работу
            driver.quit();
        }
    }

    private static void openNewTab(WebDriver driver, String url) {
        ((ChromeDriver) driver).executeScript("window.open('" + url + "', '_blank');");
    }
}
