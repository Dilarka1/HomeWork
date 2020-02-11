package tests.HomeWork4;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {
    public WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @Test(description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1() {
        Actions action = new Actions(driver);
        WebElement threedots = driver.findElement(By.xpath("//tbody/tr[13]/td[9]/div/div/a"));
        action.moveToElement(threedots).perform();
        action.moveToElement(threedots.findElement(By.xpath("//i[@class='fa-eye hide-text']"))).perform();
        action.moveToElement(threedots.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"))).perform();
        action.moveToElement(threedots.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"))).perform();
    }

    @Test(description = "Verify that “Title” column still displayed ")
    public void test2() {
        WebElement grid = driver.findElement(By.cssSelector("[title='Grid Settings']"));
        grid.click();
        List<WebElement> menu = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr/td[3]"));
        for (int i = 1; i < menu.size(); i++) {
            menu.get(i).click();
            Assert.assertFalse(menu.get(i).isSelected());
        }
    }

    @Test(description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void test3() {
        WebElement create = driver.findElement(By.cssSelector("[title='Create Calendar event']"));
        create.click();
        driver.findElement(By.cssSelector("[class='btn-success btn dropdown-toggle']")).click();

        List<WebElement> options = driver.findElements(By.xpath("//li/button"));
        for (WebElement option : options) {
            option.isEnabled();
            System.out.println(option.getText());
        }

    }

    @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4() {
        WebElement create = driver.findElement(By.cssSelector("[title='Create Calendar event']"));
        create.click();
        driver.findElement(By.cssSelector("[title='Cancel']")).click();
        BrowserUtils.wait(3);
        String expectedSubtitle = "All Calendar Events";
        WebElement subtitle = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        String Subtitle = subtitle.getText();
        System.out.println(Subtitle);
        Assert.assertEquals(Subtitle, expectedSubtitle, "Subtitle is wrong");
    }

    @Test(description = "Verify that difference between end and start time is exactly 1 hour")
    public void test5() {
        WebElement create = driver.findElement(By.cssSelector("[title='Create Calendar event']"));
        create.click();
        WebElement start = driver.findElement(By.cssSelector("input[id^='time_selector_oro_calendar_event_form_start"));
        String start1 = start.getAttribute("value");
        System.out.println(start1);
        WebElement finish = driver.findElement(By.cssSelector("input[id^='time_selector_oro_calendar_event_form_end"));
        String finish1 = finish.getAttribute("value");
        System.out.println(finish1);

    }


    @Test(description = "Verify that end time is equals to “10:00 PM”")
    public void test6() {
        WebElement create = driver.findElement(By.cssSelector("[title='Create Calendar event']"));
        create.click();
//        WebElement drop = driver.findElement(By.id("oro-dropdown-mask"));
//        WebElement start = driver.findElement(By.xpath("//li[contains(text(),'9:00 PM')]"));
//        start.click();
        WebElement start = driver.findElement(By.cssSelector("input[id^='time_selector_oro_calendar_event_form_start"));
        start.click();
        String start1 = start.getAttribute("value");
        System.out.println(start1);

        Select select = new Select(start);
        select.selectByValue("9:00 PM");


//        WebElement time = driver.findElement(By.xpath("//li[class='ui-timepicker-pm ui-timepicker-selected']"));
//                //.cssSelector("li[class='ui-timepicker-pm ui-timepicker-selected']"));
//        time.click();
//        String time1 = time.getAttribute("value");
//        System.out.println(time1);


    }


/*
 5.Select “9:00 PM” as a start time
 6.Verify that end time is equals to “10:00 PM”
 */

    @Test(description = "Verify that “All-Day Event” checkbox is selected 2. Verify that start and end time input boxes are not displayed 3.Verify that start and end date input boxes are displayed")
    public void test7() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement checkbox = driver.findElement(By.name("oro_calendar_event_form[allDay]"));
        checkbox.click();
        List<WebElement> start = driver.findElements(By.cssSelector("input[id^='time_selector_oro_calendar"));
        for (WebElement box : start) {
            //  Assert.assertFalse(box.isEnabled());
            System.out.println(box.getAttribute("value"));
            Assert.assertFalse(box.isDisplayed(), "not right");
        }

    }

/*
Test Case #7
5.Select “All-Day Event” checkbox
6.Verify that “All-Day Event” checkbox is selected
7.Verify that start and end time input boxes are not displayed
8.Verify that start and end date input boxes are displayed
 */

    @Test(description = "Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:")
    public void test8() {
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();
        WebElement repeatBox = driver.findElement(By.xpath("//div[@data-name='recurrence-settings']/div/div/div/select"));
        WebElement dayly = driver.findElement(By.xpath("//option[contains(text(),'Daily')]"));
        dayly.click();
        Select select = new Select(repeatBox);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Daily");
        repeatBox.click();
        List<WebElement> list = driver.findElements(By.xpath("//select[@name='temp-validation-name-125']/option"));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).isEnabled();
        }
    }
    /*
@Test(description ="Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:")
    public void test8(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();
        BrowserUtils.wait(3);
        WebElement repeatBox = driver.findElement(By.xpath("//div[@data-name='recurrence-settings']/div/div/div/select"));
        Select select = new Select(repeatBox);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Daily");
        BrowserUtils.wait(3);
        repeatBox.click();
        List<WebElement> list = driver.findElements(By.xpath("//select[@name='temp-validation-name-125']/option"));
        for (int i = 0; i < list.size(); i++){
            list.get(i).isEnabled();
        }
    }
     */

    @Test(description = "Verify that “Repeat” checkbox is selected; Verify that “Repeat Every” radio button is selected;" +
            "Never” radio button is selected as an “Ends” option;" +
            "Verify that following message as a summary is displayed: “Summary: Daily every 1 day")
    public void test9() {
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();
        WebElement radio = driver.findElement(By.xpath("//div[@class='controls recurrence-subview-control__items']//label[@class='fields-row']//input[1]"));
        radio.click();
        WebElement never = driver.findElement(By.xpath("//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//div[1]//label[1]//input[1]"));
        never.click();
        WebElement message = driver.findElement(By.xpath("//div[@class='control-group recurrence-summary alert-info']"));
        String message1 = message.getText();
        System.out.println(message1);
        Assert.assertTrue(message.isDisplayed());
    }
    /*
 @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day")
    public void test9(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement repeatButton = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        BrowserUtils.wait(3);
        repeatButton.click();
        Assert.assertTrue(repeatButton.isSelected());
        WebElement repeatEveryButton = driver.findElement(By.xpath("//span[text()='day(s)']/preceding-sibling :: input[3]"));
        Assert.assertTrue(repeatEveryButton.isSelected());
        WebElement neverButton = driver.findElement(By.xpath("//span[text()='Never']/preceding-sibling :: input"));
        Assert.assertTrue(neverButton.isSelected());
        WebElement summary = driver.findElement(By.xpath("//span[text()='Daily every 1 day']"));
        Assert.assertTrue(summary.isDisplayed());
    }
     */

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences")
    public void test10() {
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();


    }
/*
5.Select “Repeat” checkbox
6.Select “After 10 occurrences” as an “Ends” option.
7.Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”
 */

/*
Test Case #11
 1.Go to “https://qa1.vytrack.com/"
 2.Login as a store manager
 3.Navigate to “Activities -> Calendar Events”
 4.Click on “Create Calendar Event” button

 5.Select “Repeat” checkbox
 6.Select “By Nov 18, 2021” as an “Ends” option.
 7.Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”
 */


    /*
    Test Case #12
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Click on “Create Calendar Event” button

    5.Select “Repeat” checkbox
    6.Select “Weekly” options as a “Repeat” option
    7.Select “Monday and Friday” options as a “Repeat On” options
    8.Verify that “Monday and Friday” options are selected
    9.Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”
     */
    @AfterMethod
    public void teardown() {
        driver.quit();

    }
}

