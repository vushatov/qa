import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Insta {
    private WebDriver driver;
    private Home_insta home_insta;

@BeforeEach
public void setUp(){
    System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/qa/drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.instagram.com/");
    home_insta = new Home_insta(driver);
}

@Test
public void fillFileds(){
    home_insta.registration("vlad.petrentoivanenko@gmail.com", "Vlad TT", "Vlad_ushatttovpetrenpoivanenko12", "Tefewfew12");
    home_insta.clickTheSignUpButton();
    Assertions.assertEquals("Instagram", home_insta.checkHeader());
}

}