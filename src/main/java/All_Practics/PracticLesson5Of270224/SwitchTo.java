package All_Practics.PracticLesson5Of270224;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class SwitchTo {
    public static void main(String[] args) {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://rozetka.com.ua/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.deepl.com/uk/translator");
    }

}
