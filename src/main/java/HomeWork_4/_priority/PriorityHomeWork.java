package HomeWork_4._priority;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityHomeWork {
    public PriorityHomeWork() {
    }

    @Test(
            priority = 5
    )
    public void a() {
        Assert.assertTrue(true);
    }

    @Test(
            priority = 4
    )
    public void b() {
        Assert.assertTrue(true);
    }

    @Test(
            priority = 3
    )
    public void c() {
        Assert.assertTrue(true);
    }

    @Test(
            priority = 2
    )
    public void d() {
        Assert.assertTrue(true);
    }

    @Test(
            priority = 1
    )
    public void e() {
        Assert.assertTrue(true);
    }
}
