package tests.TestCases2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase1_5 {
    private WebDriver driver;

    /*
    Test case #1

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”

    Step 3. Enter “wrong_dob” into date of birth input box.

    Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(description = "Verify that warning message is displayed")
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name=\"birthday\"]")).sendKeys("wrong_dob");
        String expectedMessage = "The date of birth is not valid";
        String actualMessage = driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The date of birth is not valid");

        Thread.sleep(2000);
    }


    /*
    Test case #2

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”

    Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */
    @Test(description = "Verify that following options for programming languages are displayed: c++, java, JavaScript")
    public void test2() throws InterruptedException {
        List<WebElement> langs = driver.findElements(By.cssSelector("[class='form-check-label']"));
        for (WebElement each : langs) {
            Assert.assertTrue(each.isDisplayed(), " Checkbox is not displayed");
            System.out.println("Language " + each.getText());
        }
        boolean languages = driver.findElement(By.cssSelector("[class='form-check-label']")).isDisplayed();
        System.out.println("Languages are displayed: " + languages);

    }


    /*
    Test case #3

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”

    Step 3. Enter only one alphabetic character into first name input box.

    Step 4. Verify that warning message is displayed:
    “first name must be more than 2 and less than 64
     */

    @Test(description = "Verify that warning message is displayed")
    public void test3() {
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("g");
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//*[text()='first name must be more than 2 and less than 64 characters long']")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage, "Something wrong. Fix it.");


    }


/*
Test case #4

Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”

Step 3. Enter only one alphabetic character into last name input box.

Step 4. Verify that warning message is displayed:
 “The last name must be more than 2 and less than 64 characters long” */


    @Test(description = "Verify that warning message is displayed")
    public void test4() {
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("g");
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        String actualmessage = driver.findElement(By.xpath("//*[text()='The last name must be more than 2 and less than 64 characters long']")).getText();
        Assert.assertEquals(expectedMessage, actualmessage, "The last name must be more than 2 and less than 64 characters long");

    }

/*
    Test case #5

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”

    Step 3. Enter any valid first name.

    Step 4. Enter any valid last name.

    Step 5. Enter any valid user name.

    Step 6. Enter any valid password.

    Step 7. Enter any valid phone number.

    Step 8. Select gender.

    Step 9. Enter any valid date of birth.

    Step 10. Select any department.

    Step 11. Enter any job title.

    Step 12. Select java as a programming language.

    Step 13. Click Sign up.

    Step 14. Verify that following success message is displayed:
    “You've successfully completed registration!”



    Note: for using dropdown, please refer to the documentation:
    https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html
    or, please watch short video about drop-downs that is posted on canvas.
*/


    @Test(description = "Verify message is displayed")
    public void test5() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.name("firstname")).sendKeys("Mickey");
        driver.findElement(By.name("lastname")).sendKeys("Mouse");
        driver.findElement(By.name("username")).sendKeys("Disney");
        driver.findElement(By.name("email")).sendKeys("mickey@disney.ru");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("phone")).sendKeys("123-045-6790");


        driver.findElement(By.cssSelector("input[value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("09/09/2009");
        Select select = new Select(driver.findElement(By.cssSelector("select[name='department']")));
        select.selectByVisibleText("Tresurer's Office");
        Select select1 = new Select((driver.findElement(By.cssSelector("select[name='job_title']"))));
        select1.selectByVisibleText("Developer");
        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.tagName("p")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Verification message is not displayed");


    }


    @AfterMethod
    public void teardown() {
        driver.quit();

    }
}

