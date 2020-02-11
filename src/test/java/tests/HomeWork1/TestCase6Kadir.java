package tests.HomeWork1;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyStringEquality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase6Kadir {



        public static void main(String[] args) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
            driver.findElement(By.name("username")).sendKeys("user");
            String expectedErrorMessage = "The username must be more than 6 and less than 30 characters long";
            String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]")).getText();
            VerifyStringEquality.verifyStrings(expectedErrorMessage, actualErrorMessage);
            driver.close();
        }
    }

