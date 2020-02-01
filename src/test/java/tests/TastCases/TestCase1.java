package tests.TastCases;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;
import static java.lang.Thread.sleep;


/*
Test case #1
Step 1. Go to https://practice-
cybertekschool.herokuapp.com
Step 2. Click on “Sign Up For Mailing List”
Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
Expected result: Following message should be displayed:
 “Thank you for signing up. Click the button below to return to the home page.”

 Home button should be displayed.
 */

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");

       // Step 1. Go to https://practice-cybertekschool.herokuapp.com
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Sign Up For Mailing List” Step
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[43]/a")).click();
        Thread.sleep(3000);

        //Step 3. Enter any valid name
        driver.findElement(By.name("full_name")).sendKeys("“Dilara”");

        //Step 4. Enter any valid email
        driver.findElement(By.name("email")).sendKeys("dilara@gmail.com");


        //Step 5. Click on “Sign Up” button
        driver.findElement(By.name("wooden_spoon")).click();

            Thread.sleep(3000);


            //Expected result: Following message should be displayed:
        // “Thank you for signing up. Click the button below to return to the home page.”

            String ExpectedResult = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement ActualResult = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String ActualMsg = ActualResult.getText();
        System.out.println(ExpectedResult);
        System.out.println(ActualMsg);

        if (ActualMsg.equals(ExpectedResult)) {
            System.out.println("Test Passed. You are awesome!");
        } else {
            System.out.println("Test Failed. Massage not the same. You are loser. Go fix it");

        }
        // Home button should be displayed.
        boolean homeButtonVisible = driver.findElement(By.id("wooden_spoon")).isDisplayed();
        System.out.println("Home buttont present: " + homeButtonVisible);

        driver.close();
    }
}
