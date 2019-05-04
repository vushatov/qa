import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp(){

        System.setProperty("webdriver.firefox.marionette", "path/geckodriver");

        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/qa/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://twitter.com/");
        mainPage = new MainPage(driver);

    }

    @Test
    public void signIn(){
        SignIn signIn = mainPage.clickSignIn();
        Assertions.assertEquals("Log in to Twitter", signIn.checkHeader());
    }
    @Test
    public void signUp(){
        SignUp signUn = mainPage.clickSingUpButton();
        Assertions.assertEquals("Create your account", signUn.checkHeader());

    }
    @Test
    public void signInByTopButton(){
        SignIn signIn = mainPage.clickTopSingInButton();
        Assertions.assertEquals("Log in to Twitter", signIn.checkHeader());
    }
    @Test
    public void forgotPassword(){
        Forgotpassword forgotpassword = mainPage.clickForgotPasswordLink();
         Assertions.assertEquals("Find your Twitter account",forgotpassword.header() );
    }




    @AfterEach
    public void tearDown(){
        driver.quit();
    }


}
