package Lesson8._grouping;

import HomeWork_3.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GroupingTest {
    static WebDriver driver;
    @BeforeClass
    public void setUpDriver(){
        driver = DriverSetUp.setUpDriver();
    }
    @AfterClass
    public void killDriver(){
        driver.quit();
    }

    @Test(groups = {"smoke"})
    public void a(){

    }
    @Test(groups = {"smoke"})
    public void b(){

    }
    @Test(groups = {"regress"})
    public void c(){

    }

    @Test
    public void k(){

    }

    @Test
    public void q(){

    }

    @Test(groups = {"smoke"})
    public void d(){

    }
    @Test(groups = {"regress"})
    public void f(){

    }
}
