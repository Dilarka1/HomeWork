package tests.practice;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Siraji2 {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i < 50; i++) {
            button.click();
        }

        List<WebElement> buttons50 = driver.findElements(By.xpath("//div[@id='elements']//button"));
        System.out.println("Buttons: " + buttons50.size());
        int expected = 50;
        int actual = buttons50.size();
        Assert.assertEquals(actual, expected, "Test did not pass");

        for (WebElement deleteButton : buttons50) {
            deleteButton.click();
        }

        List<WebElement> deletedBox = driver.findElements(By.xpath("//div[@id='elements']//button"));
        System.out.println("Deleted boxes: " + deletedBox.size());

        int ExpectedDelete = 0;
        int ActualDelete = deletedBox.size();
          Assert.assertEquals(ExpectedDelete, ActualDelete, "переделать!!!");
        driver.quit();
    }
}