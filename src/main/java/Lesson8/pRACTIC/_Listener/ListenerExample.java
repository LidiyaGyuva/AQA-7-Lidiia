package Lesson8.pRACTIC._Listener;


import DriverSetUp.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners;

@Listeners({MyTestListeners.class})
public class ListenerExample {
    static WebDriver driver;

    public ListenerExample() {
    }

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startDriver();
    }

    @AfterClass
    public void killDriver() {
        driver.quit();
    }

    @Test
    public void a() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GkkkWR | Guinness World Records");
    }

    @Test
    public void b() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GhhhhWR | Guinness World Records");
    }

    @Test
    public void c() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }

    @Test
    public void q() {
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "GWR | Guinness World Records");
    }
}

