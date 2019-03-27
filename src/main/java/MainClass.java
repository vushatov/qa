import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {








        //System.setProperty("webdriver.gecko.driver", "C:/Users/user/IdeaProjects/qa/drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/qa/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://twitter.com/");

        //  WebDriver driver = Driver.driver;
        // System.setProperty("webdriver.edge.driver", "C:/Users/user/IdeaProjects/qa/drivers/MicrosoftWebDriver.exe");
        // System.setProperty("webdriver.opera.driver", "C:/Users/user/IdeaProjects/qa/drivers/operadriver.exe");
        // System.setProperty("phantomjs.binary.path", "C:\\Users\\user\\IdeaProjects\\qa\\drivers\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe");

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

