package HomeWork1;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWExample3 {

    /*3)
Написать метод который выводит сообщение об айди элемента,
значении тэга элемента , значении класса элемента,
значении атрибута name элемента, текста данного элемента,
а также о координатах центра контейнера данного элемента.*/

    public static void main(String[] args) {
        WebDriver driver = DriverSetUp.setUpDriver();

        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");

        WebElement otherElement = driver.findElement(By.id("globe"));
        elementInfo(otherElement);
        driver.quit();
    }


    public static void elementInfo(WebElement element) {
        System.out.println(("Value of attribute id = " + element.getAttribute("id")));
        System.out.println(("Value of attribute class = " + element.getAttribute("class")));
        System.out.println(("Name of tag is = " + element.getTagName()));
        System.out.println(("Value of attribute name = " + element.getAttribute("name")));
        System.out.println((element.getText()));

        int centreX = element.getLocation().x + element.getSize().width / 2;
        int centreY = element.getLocation().y + element.getSize().height / 2;
        Point centreOfElements = new Point(centreX, centreY);
        System.out.println("Center of attribute = "+centreOfElements);

    }

}

