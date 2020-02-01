package tests.Navigation;

import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationTestFirefox {


        public static void main(String[] args) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxDriver driver = new FirefoxDriver();
            String url = ("http://google.com");
            driver.get(url);
            String title = driver.getTitle();
            System.out.println(title);
            BrowserUtils.wait(5);
            driver.navigate().to("https://etsy.com");
            driver.get(url);
            String title2 = driver.getTitle();
            System.out.println(title2);
            BrowserUtils.wait(5);
            driver.navigate().back();
            String title3 = driver.getTitle();
            System.out.println(title3);
            driver.navigate().forward();
            String title4 = driver.getTitle();
            System.out.println(title4);
            driver.quit();
        }
    }

