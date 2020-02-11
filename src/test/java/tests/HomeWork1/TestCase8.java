package tests.HomeWork1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase8 {
    /*
    Test case #8
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “5711234354” into phone number input box.
Step 4. Verify that warning message is displayed: “Phone format is not correct”
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("phone")).sendKeys("5711234354");
        Thread.sleep(2000);

        String ExpectedMessage = "Phone format is not correct";
        WebElement ActualMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]"));

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
