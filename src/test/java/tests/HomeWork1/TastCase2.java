package tests.HomeWork1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TastCase2 {
    /*
    Test case #2
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Verify that number of listed examples is equals to 48.
Hint: use findElemnts() and size() methods.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        WebElement list = driver.findElement(By.className("list-group"));


        List<WebElement> links = list.findElements(By.tagName("li"));

        if(links.size()==48) {
            System.out.println("Number of listed examples is " +links.size() + "\n TEST PASSED");
        }
        else{
            System.out.println("Number of listed examples is not 48, but " + links.size() + "\n TEST FAILED");
        }

        driver.close();
    }
}
