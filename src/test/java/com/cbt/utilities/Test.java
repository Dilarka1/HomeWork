package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

public class Test {
    public static void ChromeTest(){
        WebDriver driver = BrowserFactory.getDriver("chrome"); // open chrome browser
        driver.get("https://google.com"); // go to the specified website
        String googletitleOne = driver.getTitle(); // returns title of a webpage (google)
        driver.navigate().to("https://etsy.com");
        String etsyTitleOne = driver.getTitle();
        driver.navigate().back();
        String googleTitleTwo = driver.getTitle(); //(google)
        System.out.println("Google Site : ") ;
        StringUtility.verifyEquals(googletitleOne, googleTitleTwo);
        driver.navigate().forward();
        String etsyTitleTwo = driver.getTitle();
        System.out.println("Etsy Site : ") ;
        StringUtility.verifyEquals(etsyTitleOne,etsyTitleTwo);

        driver.quit();
    }
}