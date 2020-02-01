package tests.TestCases3;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestCase1 {

    /*
    Test case #1
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Verify that page subtitle "Options" is displayed
     */
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        // driver.findElement(By.id("_submit")).click();
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        BrowserUtils.wait(3);
        activitiesElement.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        // BrowserUtils.wait(3);
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }


    @Test(description = "Verify subtitle 'Options' is presents")
    public void test1(){
        WebElement actualMessage = driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']"));
        String expectedResult = "Options";
        String actualResult = actualMessage.getText();
        Assert.assertEquals(actualResult, expectedResult, "not true");
        System.out.println(actualResult);
        boolean actual = driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']")).isDisplayed();
        System.out.println(actual);
    }

    @Test
    public void test2(){


        String pageNumber = driver.findElement(By.cssSelector("[type='number']")).getAttribute("value");
        Assert.assertEquals(pageNumber, "1", "Not equal to 1");
        System.out.println(pageNumber);


    }

    @Test
    public  void  test3() {
        Select select = new Select(driver.findElement(By.xpath("//div[@class='btn-group open']")));
        select.selectByVisibleText("25");

//        String button = driver.findElement(By.xpath("//div[@class='btn-group open']")).getAttribute("value");
//        Assert.assertEquals(button, "25", "Not equal to 25");
//        System.out.println(button);
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    }