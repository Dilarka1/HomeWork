package tests.HomeWork1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase6 {
    /*
    Test case #6
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “user” into username input box.
Step 4. Verify that warning message is displayed:
“The username must be more than 6 and less than 30 characters long”
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("user");
        Thread.sleep(2000);

        String ExpectedMessage = "The username must be more than 6 and less than 30 characters long";
        WebElement ActualMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]"));

        String FinalMsg = ActualMessage.getText();

        System.out.println("ActualMessage is: " + FinalMsg);


        if (FinalMsg.equals(ExpectedMessage)) {
            System.out.println("Test Passed. You are awesome!");
        } else {
            System.out.println("Test Failed. Massage not the same. You are loser. Go fix it");
        }

        driver.close();

        }
    }
