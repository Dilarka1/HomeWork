package tests.HomeWork2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 {
    /*
    Test case #7

    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”

    Step 2. And click on “File Upload".

    Step 3. Upload any file with .txt extension from your computer.

    Step 4. Click “Upload” button.

    Step 5. Verify that subject is: “File Uploaded!”

    Step 6. Verify that uploaded file name is displayed.

    Note: use element.sendKeys(“/file/path”) with specifying path
     to the file for uploading. Run this method against “Choose File” button.
     */


    private WebDriver driver;

    @Test
    public void test7() {
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/dilarakhafizova/Desktop/09.24.txt");
        driver.findElement(By.id("file-submit")).click();
        String expectedText = "09.24.txt";


        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedText);
        boolean isDisplayed = driver.findElement(By.id("uploaded-files")).isDisplayed();
        System.out.println(actualFileName + " is displayed " +isDisplayed);


        driver.quit();


    }
}
