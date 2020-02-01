package tests.TastCases;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase7 {
    /*
    Test case #7
Step 1. Go to https://practice-
cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed:
“email address is not a valid
Email format is not correct”
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("testers@email");
        Thread.sleep(2000);

        String ExpectedMessage = "email address is not a valid\nEmail format is not correct";
        WebElement ActualMessage1 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]"));
        String FinalMsg1 = ActualMessage1.getText();
        System.out.println("Expected message: " + ExpectedMessage);

        System.out.println("ActualMessage is: " + FinalMsg1);

        WebElement ActualMessage2 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[3]"));
        String FinalMsg2 = ActualMessage2.getText();

        System.out.println("ActualMessage2 is: " + FinalMsg2);
        String FinalMessage3 = FinalMsg1 + "\n" + FinalMsg2;

        System.out.println(FinalMessage3);

        if (FinalMessage3.equals(ExpectedMessage)) {
            System.out.println("Test Passed. You are awesome!");
        } else {
            System.out.println("Test Failed. Massage not the same. You are loser. Go fix it");
        }

        driver.close();

    }
}
