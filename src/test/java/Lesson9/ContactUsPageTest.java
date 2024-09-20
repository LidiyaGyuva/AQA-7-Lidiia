package Lesson9;

import DriverSetUp.DriverSetUp;
import Lesson_9.pages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners;

@Listeners(MyTestListeners.class)
public class ContactUsPageTest {
    private WebDriver driver;
    private ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.startDriver();
        contactUsPage = new ContactUsPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    public void sendMessagePositive(){
        String textToSend = "Можна создавать этот метод для редактирования текста а можно писать сразу в методе, вместо это стринги.";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.WEBMASTER)
                .setValidEmail().setOrderId()
                .enterMessage(textToSend)
                .clickButton()
                .waitForResultMessage();

        /*String textToSend = "Можна создавать этот метод для редактирования текста а можно писать сразу в методе, вместо это стринги.";
        contactUsPage.openContactUsPage();
         contactUsPage.selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.WEBMASTER);
        contactUsPage.setValidEmail().setOrderId();
      contactUsPage.enterMessage(textToSend);
    contactUsPage.clickButton();
 contactUsPage.waitForResultMessage();
        */

        Assert.assertEquals(contactUsPage.getSuccessMessage(), contactUsPage.validSuccessMessage());
    }

    @Test
    public void sendMessageNegativeEmptyMessage(){
        contactUsPage.openContactUsPage()
                .setValidEmail()
                .selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.CUSTOM)
                .setOrderId().clickButton()
                .waitForAlertMessage();
        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(ContactUsPage.Alert.MESSAGE));
    }

    @Test
    public void sendMessageNegativeInvalidMail(){
        String textToSend = "Можна создавать этот метод для редактирования текста а можно писать сразу в методе, вместо это стринги.";

        contactUsPage.openContactUsPage()
                .setInvalidEmail()
                .selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.CUSTOM)
                .setOrderId()
                .enterMessage(textToSend)
                .clickButton()
                .waitForAlertMessage();

        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(ContactUsPage.Alert.EMAIL));
    }

    /*@Test
    public void sendMessageNegativeNoChoose(){
        String textToSend = "text";

        contactUsPage.openContactUsPage()
                .setValidEmail()
                .setOrderId()
                .enterMessage(textToSend)
                .clickButton()
                .waitForAlertMessage();

        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(ContactUsPage.Alert.CHOOSE));
    }*/

    @Test
    public void sendMessagePositiveWithoutOrderID() {
        String textToSend = "text";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.WEBMASTER)
                .setValidEmail()
                .enterMessage(textToSend)
                .clickButton()
                .waitForResultMessage();
        Assert.assertEquals(contactUsPage.getSuccessMessage(), contactUsPage.validSuccessMessage());

    }




}
