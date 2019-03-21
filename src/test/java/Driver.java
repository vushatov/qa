import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver = new ChromeDriver();

    Driver(WebDriver driver) {
        if (driver == null)
            driver = new ChromeDriver();

        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}





