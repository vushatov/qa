import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver = new ChromeDriver();
    //public static WebDriver driver = new FirefoxDriver();
   // public static WebDriver driver = new OperaDriver();
   // public static WebDriver driver = new EdgeDriver();
    Driver(WebDriver driver) {
        if (driver == null)
            driver = new ChromeDriver();

        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}





