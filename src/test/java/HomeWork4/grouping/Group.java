package HomeWork4.grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Group {
    @Test(groups = {"first"})
    public void one(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"second"})
    public void two(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"first"})
    public void three(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"second"})
    public void four(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"first"})
    public void five(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"second"})
    public void six(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"first"})
    public void seven(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"second"})
    public void eight(){
        Assert.assertTrue(true);
    }

}
