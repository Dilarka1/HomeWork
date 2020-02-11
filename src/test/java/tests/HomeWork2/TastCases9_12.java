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

public class TastCases9_12 {

    /*

    Guideline:  Please create test scripts from 1 through 5 in
    the same class, with implementing @Before method for driver setup,
    and @After method for driver close. Also, do the same thing for
    tests cases from 9 through 12.


    Optional: If you want to to be a real selenium hero,
    use @DataProvider for for tests cases from 9 through 12.
    Please use following documentation:
    https://testng.org/doc/documentation-main.html#parameters-dataproviders


     Test case #9

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”

    Step 2. And click on “Status Codes”.

    Step 3. Then click on “200”.

    Step 4. Verify that following message is displayed:
    “This page returned a 200 status code”




        Test case #10

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”

    Step 2. And click on “Status Codes”.

    Step 3. Then click on “301”.

    Step 4. Verify that following message is displayed:
            “This page returned a 301 status code”


    Test case #11

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”

    Step 3. And click on “Status Codes”.

    Step 4. Then click on “404”.

    Step 5. Verify that following message is displayed:
    “This page returned a 404 status code”



    Test case #12

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”

    Step 3. And click on “Status Codes”.

    Step 4. Then click on “500”.

    Step 5. Verify that following message is displayed:
    “This page returned a 500 status code”

     */



    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Status Codes")).click();

    }


    @DataProvider(name = "test")
    public static Object[] test() {
        return new Object[]{200, 301, 404, 500};


    }


/*
    @Test(dataProvider = "test")
    public void StatusCode(String errorCode) {
        WebElement codeNumber = driver.findElement(By.linkText(errorCode));
        codeNumber.click();
        WebElement result = driver.findElement(By.tagName("p"));
        String actualresult = result.getText();
        System.out.println(actualresult);
        Assert.assertTrue(actualresult.contains(errorCode), "Wrong error code");
        driver.findElement(By.linkText("here")).click();

    }

*/




    @Test(dataProvider = "testData")
    public void Test10(String code){
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        BrowserUtils.wait(1);
        WebElement statusCode= driver.findElement(By.xpath("//a[text()='"+code+"']"));
        statusCode.click();
        WebElement message= driver.findElement(By.xpath("//p[contains(text(), " +code+")]"));
        String messageActual = message.getText().trim();
        String[] messageAct = messageActual.split("\\n");
        messageActual = messageAct[0];
        String messageExpected = "This page returned a " + code + " status code.";
        Assert.assertEquals(messageActual, messageExpected, " Incorrect message");
    }




     @AfterMethod
    public void teardown() {
      driver.quit();
      }
}
