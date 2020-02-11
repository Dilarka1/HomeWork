package tests.HomeWork1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TastCase3 {
    /*
    Test case #3
Step 1. Go to https://practice-
cybertekschool.herokuapp.com
Step 2. Click on “Multiple Buttons”
Step 3. Click on “Button 1”
Verify that result message is displayed: “Clicked on button one!”
     */
    public static void main(String[] args) throws InterruptedException {

       WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.get("https://practice-cybertekschool.herokuapp.com");
       driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a")).click();

       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]")).click();

       Thread.sleep(2000);

        String ExpectedResult = "Clicked on button one!";

        Thread.sleep(2000);

        WebElement ActualResult = driver.findElement(By.id("result"));
        String ActualMsg = ActualResult.getText();
        System.out.println(ActualMsg);

        if (ActualMsg.equals(ExpectedResult)) {
            System.out.println("Test Passed. You are awesome!");
        } else {
            System.out.println("Test Failed. Massage not the same. You are loser. Go fix it");
        }
        driver.close();






    }
}
