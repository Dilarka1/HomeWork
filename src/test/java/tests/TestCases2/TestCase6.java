package tests.TestCases2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase6 {

    /*
    Test case #6

    Step 1. Go to "https://www.tempmailaddress.com/"

    Step 2. Copy and save email as a string.

    Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”

    Step 4. And click on “Sign Up For Mailing List".

    Step 5. Enter any valid name.

    Step 6. Enter email from the Step 2.

    Step 7. Click Sign Up

    Step 8. Verify that following message is displayed:
    “Thank you for signing up. Click the button below to return to the home page.”

    Step 9. Navigate back to the “https://www.tempmailaddress.com/”

    Step 10. Verify that you’ve received an email from
    “do-not-reply@practice.cybertekschool.com”

    Step 11. Click on that email to open it.

    Step 12. Verify that email is from:
    “do-not-reply@practice.cybertekschool.com”

    Step 13. Verify that subject is:
    “Thanks for subscribing to practice.cybertekschool.com!”
     */

   @Test
           public void test1(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Step 1. Go to "https://www.tempmailaddress.com/"

        driver.navigate().to("https://www.tempmailaddress.com/");


        //Step 2. Copy and save email as a string.
        String email = driver.findElement(By.xpath("//span[@id=\"email\"]")).getText();
        System.out.println("Step 2. " + email);


        //Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
       // BrowserUtils.wait(5);

        // Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();

        //Step 5. Enter any valid name.
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Hannah Montana");

        //Step 6. Enter email from the Step 2.
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        //Step 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();

        //Step 8. Verify that following message is displayed:
        //    “Thank you for signing up. Click the button below to return to the home page.”

        WebElement SignUpText = driver.findElement(By.name("signup_message"));

        Assert.assertTrue(SignUpText.isDisplayed(), "Sign Up Message is not displayed");
        System.out.println("Step 8. " + SignUpText.getText());

        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com/");
      // BrowserUtils.wait(5);

        //Step 10. Verify that you’ve received an email from
        //“do-not-reply@practice.cybertekschool.com”

       String expectedAddress = "do-not-reply@practice.cybertekschool.com";
       WebElement actualAddress = driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
       String actualEmail = actualAddress.getText();
        System.out.println("Step 10. " + actualAddress.getText());
        actualEmail = actualEmail.trim();
       Assert.assertEquals(actualEmail, expectedAddress, "different address is displayed");



        //Step 11. Click on that email to open it.
       actualAddress.click();

      //  driver.findElement(By.id("predmet")).getText();

        //Step 12. Verify that email is from:
        // “do-not-reply@practice.cybertekschool.com”

        WebElement InsideEmail = driver.findElement(By.id("odesilatel"));
        String ExactEmail = InsideEmail.getText();
        System.out.println("Step 12. " + InsideEmail.getText());
         String NeedEmail = "do-not-reply@practice.cybertekschool.com";
         Assert.assertEquals(ExactEmail, NeedEmail, "wrong email address");

        //Step 13. Verify that subject is:
        // “Thanks for subscribing to practice.cybertekschool.com!”
        WebElement ActualSubject = driver.findElement(By.id("predmet"));
        String Subject = ActualSubject.getText();
        String ExpectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(Subject, ExpectedSubject, "something wrong. Subject is wrong");

        driver.close();

    }
}