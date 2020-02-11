package tests.HomeWork2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Zuhal9_12 {

    private WebDriver driver;
    private WebElement message;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }

    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{{"200"}, {"301"}, {"404"}, {"500"}};
    }

    @Test(dataProvider = "testData")
    public void Test10(String code) {
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        BrowserUtils.wait(1);
        WebElement statusCode = driver.findElement(By.xpath("//a[text()='" + code + "']"));
        statusCode.click();
        WebElement message = driver.findElement(By.xpath("//p[contains(text(), " + code + ")]"));
        String messageActual = message.getText().trim();
        String[] messageAct = messageActual.split("\\n");
        messageActual = messageAct[0];
        String messageExpected = "This page returned a " + code + " status code.";
        Assert.assertEquals(messageActual, messageExpected, " Incorrect message");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

