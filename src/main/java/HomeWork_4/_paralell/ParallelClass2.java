package HomeWork_4._paralell;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelClass2 {
    public ParallelClass2() {
    }

    @Test
    public void parallel6() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000L);
    }

    @Test
    public void parallel7() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000L);
    }

    @Test
    public void parallel8() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000L);
    }

    @Test
    public void parallel9() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000L);
    }

    @Test
    public void parallel10() throws InterruptedException {
        Assert.assertTrue(true);
        Thread.sleep(2000L);
    }
}
