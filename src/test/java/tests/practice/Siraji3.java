package tests.practice;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Siraji3 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.apple.com/");
        WebElement iPhone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iPhone.click();
        List<WebElement>links = driver.findElements(By.className("chapternav-icon"));
        List<WebElement> link = driver.findElements(By.partialLinkText("iPhone"));
        System.out.println(link);
        System.out.println(link.size());

        driver.quit();

    }
}
