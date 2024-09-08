package All_Practics.PracticLesson5Of270224;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticHW {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php?id_product=1&controller=product");
        Thread.sleep(2000);
        new Select(driver.findElement(By.id("group_1"))).selectByVisibleText("M");
        Thread.sleep(2000);
        driver.quit();
    }
}
