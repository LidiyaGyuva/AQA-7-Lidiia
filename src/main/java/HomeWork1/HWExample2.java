package HomeWork1;

import com.github.dockerjava.api.command.UpdateSwarmCmd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWExample2 {

    /*2)
Написать метод в параметры которого принимаются два ВебЭлемента.
метод выводит в консоль информацию какой из двух элементов располагается выше на странице,
какой из элементов располагается левее на странице,
а также какой из элементов занимает большую площадь.
Параметры метода могут также включать в себя другие аргументы, если это необходимо.*/


    public static void main(String[] args) {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/records/");
        WebElement elementFirst = driver.findElement(By.xpath("//a[@class='useraccount2 orange-background']"));
        WebElement elementSecond = driver.findElement(By.xpath("//a[@class='red-background']"));

        WebElement otherElement = driver.findElement(By.xpath("//a[@class='btn btn-icon']"));

        compareElements(elementFirst, elementSecond);
        System.out.println("=============");
        compareElements(elementFirst, otherElement);
        driver.quit();
    }


public static void compareElements (WebElement element1, WebElement element2){

    int element1Y = element1.getLocation().getY();
    int element2Y = element2.getLocation().getY();


    int element1X = element1.getLocation().getX();
    int element2X = element2.getLocation().getX();

    if (element1X>element2X){
        System.out.println("Второй элемент расположен левее на странице.");
    } else if (element1X < element2X) {
        System.out.println("Первый элемент расположен левее на странице.");

    } else {
        System.out.println("Оба элемента находятся на одном уровне по горизонтали.");
    }

    if (element1Y > element2Y){
        System.out.println("Второй элемент расположен выше на странице.");
    } else if (element1Y < element2Y){
        System.out.println("Первый элемент расположен выше на странице.");
    } else {
        System.out.println("Оба элемента находятся на одном уровне по вертикали.");
    }

    int elementArea1 = element1.getSize().getHeight()*element1.getSize().getWidth();
    int elementArea2 = element2.getSize().getHeight()*element2.getSize().getWidth();

    if (elementArea1> elementArea2){
        System.out.println("Первый элемент занимает большую площадь.");
    } else if (elementArea1 < elementArea2) {
        System.out.println("Второй элемент занимает большую площадь.");

    } else {
        System.out.println("Оба элемента занимают одинаковую площадь.");
    }

}
}
