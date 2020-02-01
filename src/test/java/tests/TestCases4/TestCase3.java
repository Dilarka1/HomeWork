package tests.TestCases4;

//from Mihribana

    import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public class TestCase3{
        private WebDriver driver;
        private WebDriverWait wait;
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
        @AfterMethod
        public void teardown() {
         //   driver.quit();
        }
        //     //tbody//tr[13]/td[9]/div/div/a
        @Test(description = "Verify ... contains edit, delete, view options")
        public void test1() {
            Actions action = new Actions(driver);
            WebElement threeDots = driver.findElement(By.xpath("//tbody/tr[13]/td[9]/div/div/a"));
            action.moveToElement(threeDots).perform();
            BrowserUtils.wait(2);
            action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-eye hide-text']"))).perform();
            BrowserUtils.wait(1);
            action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"))).perform();
            BrowserUtils.wait(1);
            action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"))).perform();
            BrowserUtils.wait(2);
//        WebElement ThreeDot = driver.findElement(By.xpath("//tbody//tr[13]/td[9]/div/div/a"));
//        action.moveToElement(ThreeDot).perform();
//        BrowserUtils.wait(2);
//        WebElement textOfView = driver.findElement(By.cssSelector("[class=\"fa-eye hide-text\"]"));
//        action.moveToElement(textOfView).perform();
//        BrowserUtils.wait(2);
//        Assert.assertTrue(textOfView.isDisplayed());
////   [class="fa-pencil-square-o hide-text"]:nth-of-type
//        WebElement edit = driver.findElement(By.xpath("//i[@class=\"fa-pencil-square-o hide-text\"]"));
//        action.moveToElement(edit).perform();
//        BrowserUtils.wait(2);
//        WebElement delete = driver.findElement(By.xpath("//i[@class=\"fa-trash-o hide-text\"]"));
//        action.moveToElement(delete).perform();
//        BrowserUtils.wait(2);
        }
        @Test
        public void test2() {
            driver.findElement(By.cssSelector("[class=\"fa-cog hide-text\"]")).click();
// //tbody[@class="ui-sortable"]/tr/td[3]
            List<WebElement> gridList = driver.findElements(By.xpath("//tbody[@class=\"ui-sortable\"]/tr/td[3]"));
            for (int i = 1; i < gridList.size(); i++) {
                gridList.get(i).click();
                Assert.assertFalse(gridList.get(i).isSelected());
            }
        }
        @Test (description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
        public void test3() {
            driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
            WebElement saveAndCloseButton = driver.findElement(By.cssSelector("a[class='btn-success btn dropdown-toggle'']"));
            BrowserUtils.wait(2);
            saveAndCloseButton.click();
            List<WebElement> options = driver.findElements(By.xpath("//li/button"));
            for (WebElement option : options
            ) {
                option.isEnabled();
                System.out.println(option.getText());
            }
            BrowserUtils.wait(3);
        }
        @Test (description = "Verify that “All Calendar Events” page subtitle is displayed")
        public void test4(){
            driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
            WebElement cancelButton = driver.findElement(By.xpath("//a[@title='Cancel']"));
            BrowserUtils.wait(2);
            cancelButton.click();
            BrowserUtils.wait(2);
            String expectedSubtitle = "All Calendar Events";
            String actualSub = driver.findElement(By.className("oro-subtitle")).getText();
            System.out.println(actualSub);
            // .oro-subtitle
            Assert.assertEquals(actualSub, expectedSubtitle,  "Subtitle is wrong");
        }
        @Test (description = "Verify that difference between end and start time is exactly 1 hour")
        public void test5(){
            driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
            BrowserUtils.wait(3);
            WebElement start = driver.findElement(By.cssSelector("input[id='time_selector_oro_calendar_event_form_start-uid-5de03880a5cc4']"));
            start.getText();
        }

}
