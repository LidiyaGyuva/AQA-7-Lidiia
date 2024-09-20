package HomeWork_4.foxtrotTest;


import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CustomWaiterClass {
    private final WebDriver driver;

    public CustomWaiterClass(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> fluentWait() {
        return (new FluentWait(this.driver)).withTimeout(Duration.ofSeconds(20L)).pollingEvery(Duration.ofSeconds(1L)).ignoring(NoSuchElementException.class).ignoring(ElementNotInteractableException.class).ignoring(InvalidElementStateException.class).ignoring(NoAlertPresentException.class).ignoring(NoSuchFrameException.class);
    }

    private void waitForFunction(Function function) {
        FluentWait<WebDriver> wait = this.fluentWait();
        wait.until(function);
    }

    public WebElement waitForVisibilityOfElementLocated(By locator) {
        return (WebElement)this.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForFrameAndSwitch(By locator) {
        this.waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public Alert waitForAlertAndSwitch() {
        return (Alert)this.fluentWait().until(ExpectedConditions.alertIsPresent());
    }
}
