import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) throws InterruptedException, IOException {

        //System.setProperty("webdriver.gecko.driver", "C:/Users/user/IdeaProjects/qa/drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/qa/drivers/chromedriver.exe");
        WebDriver driver = Driver.driver;
       // System.setProperty("webdriver.edge.driver", "C:/Users/user/IdeaProjects/qa/drivers/MicrosoftWebDriver.exe");
       // System.setProperty("webdriver.opera.driver", "C:/Users/user/IdeaProjects/qa/drivers/operadriver.exe");
       // System.setProperty("phantomjs.binary.path", "C:\\Users\\user\\IdeaProjects\\qa\\drivers\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe");

        MainPage mainPage = new MainPage(driver);
        mainPage.invalidLogin("wdwd@efe.ee", "efefef");













       /*


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://18.185.161.25");
        if (driver.findElements(By.xpath("//div[@class=\"decent-bar\"]//span[1]")).size()!=0){
        driver.findElement(By.xpath("//div[@class=\"decent-bar\"]//span[1]")).click();}



        Login testLogin = new Login();
        testLogin.openBasePage();
        testLogin.login();
        System.out.println("Success test login page");
        Onboarding onboarding = new Onboarding();
        onboarding.flowPortfolio();
        System.out.println("Success test onboarding");
        DeleteAllPortfolios deleteAllPortfolios = new DeleteAllPortfolios();
        // deleteAllPortfolios.del();
        System.out.println("Success delete all portfolios"); */
        // driver.quit();


    }
}
