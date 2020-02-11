package tests.HomeWork1;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase1Nurulla {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        String expectedResultOne ="Thank you for signing up. Click the button below to return to the home page.";
        String expectedResultTwo = "Home";
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Cagri Durmaz");
        Thread.sleep(3000);
        driver.findElement(By.name("email")).sendKeys("testcaseone@maildrop.cc");
        Thread.sleep(3000);
        driver.findElement(By.name("wooden_spoon")).click();
        String actualResultOne = driver.findElement(By.name("signup_message")).getText();
        String actualResultTwo = driver.findElement(By.id("wooden_spoon")).getText();
        System.out.println("First Verification");
        System.out.println("Expected Result " + expectedResultOne);
        System.out.println("Actual Result "+ actualResultOne);
        StringUtility.verifyEquals(expectedResultOne,actualResultOne);
        System.out.println("Second Verification");
        System.out.println("Expected Result " + expectedResultTwo);
        System.out.println("Actual Result "+ actualResultTwo);
        StringUtility.verifyEquals(expectedResultTwo, actualResultTwo);
        driver.close();
    }
}
