import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MoveSlider {
    static WebDriver driver = Driver.driver;

    public static void movingSlider(int a, String b) {
        WebElement slider = driver.findElement(By.xpath(b));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, a, 0).build();
        action.perform();

    }
}
