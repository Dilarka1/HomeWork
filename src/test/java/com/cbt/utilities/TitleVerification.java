package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        ArrayList<String>Title = new ArrayList<String>();
        WebDriver driver = BrowserFactory.getDriver("chrome");
        for(int i = 0 ; i < urls.size(); i++){
            driver.get(urls.get(i));
            Title.add(driver.getTitle());
            BrowserUtils.wait(5);
            if (urls.get(i).startsWith("http://practice.cybertekschool.com")){
                System.out.println(urls.get(i) + " : TEST PASSED");
            }else {
                System.out.println(urls.get(i) + " : TEST FAILED");
            }
        }
        int count = 0;
        for(int i = 0; i<Title.size();i++){
            if(Title.get(0).equals(Title.get(i))){
                count++;
            }
        }
        if(count == Title.size()){
            System.out.println("ALL TITLES ARE SAME!");
        }
        driver.quit();

    }
}
