package All_Practics.Practic250224;

import HomeWork1.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tast2For250224 {

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[3]/rz-user/button")
    private static WebElement loginPageOpen;

    @FindBy(id = "auth_email")
    private static WebElement idOpenString;

    @FindBy(id = "auth_pass")
    private static WebElement passwordOpenString;

    @FindBy(xpath = "//label[@class = 'auth-modal__remember-checkbox']")
    private static WebElement checkboxOpenPage;

    @FindBy(xpath = "/html/body/app-root/rz-single-modal-window/div[3]/div[2]/rz-user-identification/rz-auth/div/form/fieldset/div[5]/button[2]")
    private static WebElement registrationOpenText;


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();

        Tast2For250224 page = new Tast2For250224();
        PageFactory.initElements(driver, page);
        driver.get("https://rozetka.com.ua/");
        loginPageOpen.click();
        Thread.sleep(1500);
        idOpenString.sendKeys("Login");
        passwordOpenString.sendKeys("Password");
        Thread.sleep(1500);
        checkboxOpenPage.click();
        System.out.println(registrationOpenText.getText());
        driver.quit();





    }
}
