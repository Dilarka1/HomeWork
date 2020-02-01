package tests.Navigation;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
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

