import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Forgotpassword {
    WebDriver driver;

    public Forgotpassword(WebDriver driver) {
        this.driver = driver;
    }
    private By header = By.xpath("//div[@class=\"PageHeader Edge\"]");

    public String header (){
        return driver.findElement(header).getText();
    }
}
