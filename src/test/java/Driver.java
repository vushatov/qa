import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver = new ChromeDriver();
    public static WebDriver driver1 = new FirefoxDriver();



    Driver(WebDriver driver) {
        System.out.println("Select browser: Chrome - 1, Firefix -2: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        switch (number){
            case 1:
                driver = new ChromeDriver();
            case 2:
                driver = new FirefoxDriver();
        }
        if (driver == null)
            driver = new ChromeDriver();

        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}





