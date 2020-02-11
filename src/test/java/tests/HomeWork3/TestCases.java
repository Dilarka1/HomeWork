package tests.HomeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestCases {


    public WebDriver driver;
    public WebDriverWait wait;


    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        WebElement loaderMask = null;

        if (driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size() > 0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }


    @Test(description = "Verify subtitle 'Options' is presents")
    public void test1() {
        WebElement actualMessage = driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']"));
        String expectedResult = "Options";
        String actualResult = actualMessage.getText();
        Assert.assertEquals(actualResult, expectedResult, "not true");
        System.out.println(actualResult);
        boolean actual = driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']")).isDisplayed();
        System.out.println(actual);
    }

    @Test(description = "Verify that page number is equals to '1'")
    public void test2() {


        // WebElement pageNumber = driver.findElement(By.xpath("//input[@class='input-widget']"));
        String expectedPageNum = "1";
        WebElement actualPageNum = driver.findElement(By.xpath("//input[@class='input-widget']"));
        //Assert.assertEquals(actualPageNum, expectedPageNum, "not working");
        String num = actualPageNum.getAttribute("value");
        System.out.println(num + "should be 1");
        Assert.assertEquals(num, expectedPageNum, "not 1");


    }

    @Test(description = "Verify that view per page number is equals to '25'")
    public void test3() {
        WebElement button25 = driver.findElement(By.xpath("//button[contains(@class,'btn dropdown-toggle')]"));
        String expectedButton25 = "25";
        String actualButton25 = button25.getText();
        System.out.println(actualButton25 + "should be 25");
        Assert.assertEquals(actualButton25, expectedButton25, "wrong button");

    }

    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4() {

        WebElement expectedRowCount = driver.findElement(By.xpath("//label[contains(text(),'Total of 20 records')]"));
        int row = driver.findElements(By.cssSelector("td[data-column-label='Selected Rows']")).size();
        System.out.println(row);
        Assert.assertTrue(expectedRowCount.getText().contains("20"));
    }

    @Test(description = "Verify that all calendar events were selected")
    public void test5() {
        List<WebElement> checkbox = driver.findElements(By.cssSelector("td[data-column-label='Selected Rows']"));
        for (WebElement box : checkbox) {
            box.click();

        }
    }


    @Test(description = "Verify that following data is displayed")
    public void test6() {
        WebElement testerMeet = driver.findElement(By.xpath("//td[contains(text(),'Testers meeting')]"));
        testerMeet.click();
        WebElement tester = driver.findElement(By.cssSelector("div[class='form-horizontal']"));

        System.out.println(tester.getText());

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}