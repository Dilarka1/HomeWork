package tests.TestVerification;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TestVerification2_2 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/",
                "https://walmart.com",
                "https://westelm.com/");

        //  ArrayList<String> title = new ArrayList<String>();
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://luluandgeorgia.com");
        String title = driver.getTitle().toLowerCase().replaceAll(" ", "");
        BrowserUtils.wait(5);
        System.out.println(title);


        if (title.startsWith("luluandgeorgia")) {
            System.out.println(urls + " lulu and georgia :   PASSED THE TITLE TEST");
        } else {
            System.out.println(urls + " lulu and georgia:   FAILED THE TITLE TEST");
        }

        driver.get("https://wayfair.com");
        String title3 = driver.getTitle().toLowerCase().replaceAll(" ", "");
        BrowserUtils.wait(5);
        System.out.println(title3);


        if (title3.startsWith("wayfair")) {
            System.out.println(urls + " wayfair :   PASSED THE TITLE TEST");
        } else {
            System.out.println(urls + " wayfair:   FAILED THE TITLE TEST");
        }

        driver.get("https://walmart.com");
        String title4 = driver.getTitle().toLowerCase().replaceAll(" ", "");
        BrowserUtils.wait(5);
        System.out.println(title4);


        if (title4.startsWith("walmart")) {
            System.out.println(urls + " walmart :   PASSED THE TITLE TEST");
        } else {
            System.out.println(urls + " walmart:   FAILED THE TITLE TEST");
        }


        driver.get("https://westelm.com");
        String title2 = driver.getTitle().toLowerCase().replaceAll(" ", "");
        BrowserUtils.wait(5);
        System.out.println(title2);


        if (title2.startsWith("westelm")) {
            System.out.println(urls + " westelm :   PASSED THE TITLE TEST");
        } else {
            System.out.println(urls + " westelm:   FAILED THE TITLE TEST");
        }
        driver.quit();

    }


}


