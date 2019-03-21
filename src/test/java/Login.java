import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Login {
    static WebDriver driver = Driver.driver;

    Login() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
    }

    boolean baseFlow() {
        this.openBasePage();
        this.fillFields("//input[@type='email']", "vushatov@qualium.systems.com.ua");
        this.fillFields("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]", "vushatov@qualium-systems.com.ua");
        this.delDataFromFild("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]");
        this.delDataFromFild("//input[@type='email']");
        this.goResetPassword();
        registration();
        login();

        return true;
    }

    boolean openBasePage() {
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/sign-in")) {
            driver.get("http://18.185.161.25/sign-in");
            System.out.println("Not current page opens " + driver.getCurrentUrl());
            return false;
        } else return true;
    }

    void fillFields(String a, String b) {
        driver.findElement(By.xpath(a)).sendKeys(b);
    }

    void delDataFromFild(String a) {
        driver.findElement(By.xpath(a)).clear();

    }

    void goResetPassword() {

        driver.findElement(By.xpath("//a[contains(text(),'Passwort vergessen')]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rvrvrv@ffe.thth");
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/button[1]/span[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]"));
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/h5[1]"));
        driver.findElement(By.xpath("//a[contains(text(),'Passwort vergessen')]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vushatov@qualium-systems.com.ua");
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/button[1]/span[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]"));
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/h5[1]"));
    }

    void registration() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]")).click();
        if (driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/h5[1]")) != null) {

            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")).sendKeys("th@eff.efef");
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]")).sendKeys("12345aass");
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]")).sendKeys("12345aass");
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]"));
        } else System.out.println("Invalid registation page opens!! " + driver.getCurrentUrl());
        if (driver.findElements(By.xpath("//div[@class=\"page-container-holder _small _login\"]")).size()!=1)
        {
            driver.get("http://18.185.161.25/sign-in");
        }



    }
    void login(){
        fillFields("//input[@type='email']", "vushatov+989@qualium-systems.com.ua");
        fillFields("//input[@type='password']", "vushatov+989@qualium-systems.com.ua");
        driver.findElement(By.xpath("//div[@class=\"box-shadow\"]//div[3]//div[1]")).click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException n1) {
            n1.printStackTrace();}

    }}



