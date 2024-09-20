package Lesson_9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public enum SubjectHeader {
        CUSTOM, WEBMASTER
    }

    public enum Alert {
        EMAIL, CHOOSE, MESSAGE
    }


    private static class Strings {
        private final static String successMessage = "Your message has been successfully sent to our team.";
        private final static String selectOption1 = "Customer service";
        private final static String selectOption2 = "Webmaster";
        private final static String url = "http://www.automationpractice.pl/index.php?controller=contact";
        private final static String validMail = "abx@abc.abc";
        private final static String orderID = "12345";
        private final static String alertInvalidMessage = "Invalid email address.";
        private final static String inValidMail = "abcabc";
        private final static String alertInvalidChooseMessage = "Please select a subject from the list provided. ";
        private final static String alertInvalidEmptyMessage = "The message cannot be blank.";
    }



    @FindBy(id = "id_contact")
    private static WebElement subjectHeading;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "id_order")
    private WebElement order;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(id = "submitMessage")
    private WebElement buttonSend;

    @FindBy(css = ".alert.alert-success")
        private WebElement successInfoMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    private static WebElement alertMessage;


    //выбрать один из селектов чтобы отправить сообщение

public ContactUsPage selectOptionFromSubjectHeading (SubjectHeader subjectHeader){
    Select select = new Select(subjectHeading);
    switch (subjectHeader){
        case WEBMASTER -> select.selectByVisibleText(Strings.selectOption2);
        case CUSTOM -> select.selectByVisibleText(Strings.selectOption1);
    }
    return this;
}

public ContactUsPage openContactUsPage(){
    driver.get(Strings.url);
    return this;
}



//отправить почту в строку

public ContactUsPage setValidEmail(){
    email.sendKeys(Strings.validMail);
    return this;
}


//ввести следующую строку
    public ContactUsPage setOrderId(){
        order.sendKeys(Strings.orderID);
        return this;
    }

  //отправить само сообщение и дождаться результата ожидаемого

    public ContactUsPage enterMessage(String text){
    message.sendKeys(text);
    return this;
    }

    public ContactUsPage clickButton(){
    buttonSend.click();
    return this;
    }
    public ContactUsPage waitForResultMessage(){
    wait.until(ExpectedConditions.visibilityOf(successInfoMessage));
    return this;
    }

    public String getSuccessMessage(){
    return successInfoMessage.getText();
    }

    public String validSuccessMessage(){
    return Strings.successMessage;
    }

    //NEGATIVE TEST

    public ContactUsPage setInvalidEmail(){
        email.sendKeys(Strings.inValidMail);
        return this;
    }

    public ContactUsPage waitForAlertMessage(){
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return this;
    }

    public String getAlertMessage(){
        return alertMessage.getText();
    }

    public String alertResultMessage(Alert alert){
    String result="";
    switch (alert){
        case CHOOSE -> result=Strings.alertInvalidChooseMessage;
        case EMAIL -> result=Strings.alertInvalidMessage;
        case MESSAGE -> result=Strings.alertInvalidEmptyMessage;
    }
        return result;
    }

}
