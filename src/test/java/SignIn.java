import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
    WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver = driver;
    }
    private By EmailFiled = By.xpath("//input[@class=\"js-username-field email-input js-initial-focus\"]");
    private By PasswordField = By.xpath("//input[@class=\"js-password-field\"]");
    private By LogInButton = By.xpath("//button[@type=\"submit\"]"); //не обработано
    private By ForgotPasswordLink = By.xpath("//label[@class=\"t1-label remember\"]//a[@class=\"forgot\"]");
    private By SignUpLink = By.xpath("//a[@id=\"login-signup-link\"]");
    private By RememberMeCheckBox = By.xpath("//label[@class=\"t1-label remember\"]//input[@type=\"checkbox\"]");
    private By HomeButton = By.xpath("//a[@class=\"js-nav js-tooltip js-dynamic-tooltip\"]");

    public SignIn fillEmailField (String email){
        driver.findElement(EmailFiled).sendKeys(email);
        return this;
    }
    public SignIn fillPasswordField (String password){
        driver.findElement(PasswordField).sendKeys(password);
        return this;
    }
    public Forgotpassword clickForgotPasswordButton (){
        driver.findElement(ForgotPasswordLink).click();
        return new Forgotpassword(driver);
    }
    public SignUp clickSignUpLink (){
        driver.findElement(SignUpLink).click();
        return new SignUp(driver);
    }
    public SignIn turnOnCheckbox (){
        driver.findElement(RememberMeCheckBox).click();
        return this;
    }
    public MainPage clickHomebutton(){
        driver.findElement(HomeButton).click();
        return new MainPage(driver);
    }
    public void clickLogin(){
        driver.findElement(LogInButton).click();
    }

    public SignIn InvalidLogin (String email, String password){
        this.fillEmailField(email);
        this.fillPasswordField(password);
        this.clickLogin();
        return this;
    }


}
