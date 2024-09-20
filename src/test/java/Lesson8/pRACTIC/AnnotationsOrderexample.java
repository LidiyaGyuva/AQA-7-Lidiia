package Lesson8.pRACTIC;

import org.testng.annotations.*;

public class AnnotationsOrderexample {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }



    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @Test
    public void test(){
        System.out.println("test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }
}
