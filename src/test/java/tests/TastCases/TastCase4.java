package tests.TastCases;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TastCase4 {
    /*
    Test case #4
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into first name input box.
Step 4. Verify that warning message is displayed: “first name can only consist of alphabetical letters”
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("123");
        Thread.sleep(2000);

        String ExpectedResult = "first name can only consist of alphabetical letters";
        WebElement ActualResult = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]"));
        String ActualMsg = ActualResult.getText();

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
