package tests.TastCases;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TastCase5 {
    /*
    Test case #5
Step 1. Go to https://practice-
cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into last name input box.
Step 4. Verify that warning message is displayed:
“The last name can only consist of alphabetical letters and dash”
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("lastname")).sendKeys("123");
        Thread.sleep(2000);

        String ExpectedResult = "The last name can only consist of alphabetical letters and dash";
        WebElement ActualResult = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]"));
        String ActualMsg = ActualResult.getText();
        Thread.sleep(2000);

        System.out.println(ActualMsg);

        if(ActualMsg.equals(ExpectedResult)){
            System.out.println("Test Passed. You are cool!");
        }
        else {
            System.out.println("Test FAILED! Go fix your code!!!");
        }

        driver.close();
    }
}
