package HomeWork4.parallelismus;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelClass1 {
    @Test
    public void parallel1() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000);
    }

    @Test
    public void parallel2() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000);
    }

    @Test
    public void parallel3() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000);
    }

    @Test
    public void parallel4() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000);
    }

    @Test
    public void parallel5() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000);
    }


}
