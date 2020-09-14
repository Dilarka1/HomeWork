package tests.practice;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Siraji {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);
        WebElement list = driver.findElement(By.className("cb1-element"));
        List<WebElement> buttons = list.findElements(By.xpath("//label//input[@class='cb1-element']"));
        System.out.println("Buttons:" + buttons.size());

        int index = 1;
        for (WebElement box : buttons) {
            if (box.isEnabled() && !box.isSelected()) {
                box.click();
                System.out.println("Button #" + index + " was clicked");
            } else {
                System.out.println("Button #" + index + " was not clicked");
            }
            index++;
        }
        driver.quit();
    }
}
