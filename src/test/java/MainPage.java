import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By SingInButton = By.xpath("//a[2][@href=\"/login\"]");
    private By SingUpButton = By.xpath("//div[@class=\"StaticLoggedOutHomePage-buttons\"]//a[@href=\"https://twitter.com/signup\"]");
    private By TopSingInButton = By.xpath("//div[@class=\"StaticLoggedOutHomePage-login\"]//form[@class=\"LoginForm js-front-signin\"]/input[@type=\"submit\"]");
    private By EmailField = By.xpath("//form[@data-component=\"login_callout\"]//input[@placeholder=\"Phone, email, or username\"]");
    private By PasswordFiled = By.xpath("//form[@data-component=\"login_callout\"]//input[@autocomplete=\"current-password\"]");
    private By ForgotPasswordLink = By.xpath("//form[@data-component=\"login_callout\"]//a[@class=\"forgot\"]");

    public SignIn clickSignIn(){
        driver.findElement(SingInButton).click();
        return new SignIn(driver);
    }
    public SignIn clickTopSingInButton(){
        driver.findElement(TopSingInButton).click();
        return new SignIn(driver);
    }
    public SignUp clickSingUpButton(){
        driver.findElement(SingUpButton).click();
        return new SignUp(driver);
    }
    public Forgotpassword clickForgotPasswordLink(){
        driver.findElement(ForgotPasswordLink);
        return new Forgotpassword(driver);
    }

    public MainPage typeEmailField (String email){
        driver.findElement(EmailField).sendKeys(email);
        return this;
    }
    public MainPage typePasswordFiled (String password){
        driver.findElement(PasswordFiled).sendKeys(password);
        return this;
    }

    public SignIn invalidLogin(String email, String password){
        this.typeEmailField(email);
        this.typePasswordFiled(password);
        this.clickTopSingInButton();
        return new SignIn(driver);    }

}

