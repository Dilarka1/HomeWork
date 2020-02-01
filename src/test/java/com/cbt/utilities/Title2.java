package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Title2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/", "https://www.wayfair.com/",
                "https://www.walmart.com/", "https://www.westelm.com/");

        for (int i = 0; i < urls.size(); i++) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(urls.get(i));
            String title = driver.getTitle();
            title = title.toLowerCase();
            title = title.replace(" ", "");
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());

            if (urls.get(i).contains(title)) {
                System.out.println("Passed");
            } else {
                System.out.println("Failed");
            }
        }
    }
}
