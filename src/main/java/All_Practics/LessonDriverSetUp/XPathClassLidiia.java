package All_Practics.LessonDriverSetUp;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPathClassLidiia {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record");
    driver.findElement(By.xpath("//a[@title = 'Search']")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("super herous.");
    Thread.sleep(1500);
    driver.findElement(By.xpath("//button[text() = 'Search']")).click();
    Thread.sleep(1500);

    ////a[contains(text(), 'CATION PR')]
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record");
        driver.findElement(By.xpath("//a[contains(text(), 'CATION PR')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//a[contains(@href, '/search/applicati')])[1]")).click();

        Thread.sleep(1500);
    driver.quit();



    }
}
