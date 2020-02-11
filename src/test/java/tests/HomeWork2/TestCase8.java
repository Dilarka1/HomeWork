package tests.HomeWork2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8 {

    /*
    Test case #8

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”

    Step 2. And click on “Autocomplete”.

    Step 3. Enter “United States of America” into country input box.

    Step 4. Verify that following message is displayed:
    “You selected: United States of America”
    */

    private WebDriver driver;

    @Test
    public void test7() {
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        String message = "You selected: United States of America";
        String actualmessage =  driver.findElement(By.id("result")).getText();
        Assert.assertEquals(message, actualmessage,"message is wrong");
        boolean isDisplayed = driver.findElement(By.id("myCountry")).isDisplayed();
        System.out.println(actualmessage + " is displayed " +isDisplayed);
        driver.close();
    }
}