import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
    WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }
    private By header = By.xpath("//div[contains(text(),'Create your account')]");

    public String checkHeader(){
        return driver.findElement(header).getText();
    }

}
