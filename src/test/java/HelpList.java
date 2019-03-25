import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public class HelpList {
    static WebDriver driver = Driver.driver;

    HelpList() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
    }

    //        WebElement link = driver.findElement(By.linkText("Log in"));
//        WebElement link2 = driver.findElement(By.partialLinkText("Donate"));
//        WebElement searchFild = driver.findElement(By.name("search"));
//        WebElement searchButton = driver.findElement(By.className("searchButton"));
//        WebElement li = driver.findElement(By.id("ca-viewsource"));
//        driver.findElement(By.xpath("//a[@title='Visit the main page']"));
    // Thread.sleep(1000);
    void helpMess() throws IOException {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////навести мышкой на элемент
        WebElement link = driver.findElement(By.xpath("//a[@href=\"/actual\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////////////////////////////перетащить элемент
        driver.get("https://trello.com/login");
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("vushatov+1@qualium-systems.com.ua");
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("vushatov+1@qualium-systems.com.ua");
        driver.findElement(By.xpath("//input[@id=\"login\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"board-tile-details is-badged\"]")).click();
        actions.dragAndDrop(driver.findElement(By.xpath("//a[1][@class=\"list-card js-member-droppable ui-droppable\"]")),
                driver.findElement(By.xpath("//div[2][@class=\"js-list list-wrapper\"]"))).build().perform();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

        actions.doubleClick(driver.findElement(By.xpath("d"))); // двойное нажатие на кнопку
        actions.contextClick(driver.findElement(By.xpath("ewf"))); // нажатие правой кнопкой
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////сон в милисекундах
        driver.switchTo().alert().accept(); // нажатие да на алерте джаваскрипт
        try {
            Thread.sleep(3000);
        } catch (InterruptedException n) {
            n.printStackTrace();
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////// работа с окнами,вкладками браузера
        String maneWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href=\"javascript:showAgreement('jdk-12-oth-JPR');\"]")).click();
        for (String windowHandle:driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(By.xpath("//li[1]//a[@class=\"level01_top_link_subnav\"]")).click();
        driver.switchTo().window(maneWindow);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        link.isDisplayed(); // отображаеться
        link.isSelected(); // выбрана
        link.isEnabled(); // доступна

        link.sendKeys(Keys.ENTER);//нажать кнопку Enter клавиатуры
        link.sendKeys(Keys.chord(Keys.SHIFT, Keys.ALT, Keys.ENTER)); //нажатие нескольких кнопок одновременно
        link.sendKeys(Keys.chord(Keys.CONTROL, "a")); // выделить текст и можно вырезать, скопировать, вставить и тд

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // сделать скриншот
        FileHandler.copy(screenshot, new File("c:\\tmp\\screenshot.png")); // сохранить сериншот

       driver.findElement(By.xpath("12")).sendKeys("C:\\Users\\user\\Desktop\\Screenshot_1.png"); //загрузка файлов


    }
}
