import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_insta {
    private WebDriver driver;
    public Home_insta(WebDriver driver) {this.driver = driver;}

    private By LogInButton = By.xpath("//a[@href=\"/accounts/login/?source=auth_switcher\"]");
    private By SignUpButton = By.xpath("//button[@type=\"submit\"]");
    private By LoginWithFacebook = By.xpath("//button[@type=\"button\"]");
    private By MobOrEmailField = By.xpath("//input[@name=\"emailOrPhone\"]");
    private By FullNameField = By.xpath("//input[@name=\"fullName\"]");
    private By Username = By.xpath("//input[@name=\"username\"]");
    private By Password = By.xpath("//input[@name=\"password\"]");
    private By AppStore = By.xpath("//img[@alt=\"Available on the App Store\"]");
    private By GooglePlay = By.xpath("//img[@alt=\"Available on Google Play\"]");
    private By Microsoft = By.xpath("//img[@alt=\"Get it from Microsoft\"]");
    private By Header = By.xpath("//h1[@class=\"NXVPg Szr5J  coreSpriteLoggedOutWordmark\"]");

    public SecondStepRegist clickTheSignUpButton (){
        driver.findElement(SignUpButton).click();
        return new SecondStepRegist(driver);
    }
    public String checkHeader(){
        return driver.findElement(Header).getText();
    }

    public Home_insta registration (String Email, String FullName, String Username, String Password){
        driver.findElement(MobOrEmailField).sendKeys(Email);
        driver.findElement(FullNameField).sendKeys(FullName);
        driver.findElement(this.Username).sendKeys(Username);
        driver.findElement(this.Password).sendKeys(Password);
        return this;
    }







}
