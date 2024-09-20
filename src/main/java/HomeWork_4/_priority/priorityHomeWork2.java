package HomeWork_4._priority;

import org.testng.Assert;
import org.testng.annotations.Test;

public class priorityHomeWork2 {
    public priorityHomeWork2() {
    }

    @Test(
            dependsOnMethods = {"b"},
            alwaysRun = true
    )
    public void a() {
        Assert.assertTrue(true);
    }

    @Test(
            dependsOnMethods = {"c"},
            alwaysRun = true
    )
    public void b() {
        Assert.assertTrue(true);
    }

    @Test(
            dependsOnMethods = {"d"},
            alwaysRun = true
    )
    public void c() {
        Assert.assertTrue(true);
    }

    @Test(
            dependsOnMethods = {"e"},
            alwaysRun = true
    )
    public void d() {
        Assert.assertTrue(true);
    }

    @Test(
            dependsOnMethods = {"f"},
            alwaysRun = true
    )
    public void e() {
        Assert.assertTrue(true);
    }

    @Test(
            dependsOnMethods = {"g"},
            alwaysRun = true
    )
    public void f() {
        Assert.assertTrue(true);
    }

    @Test
    public void g() {
        Assert.assertTrue(true);
    }
}
