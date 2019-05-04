import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Home {

    static WebDriver driver = Driver.driver;
    
    String[] links = {"//h2[contains(text(),'Online-Vermögens\u00ADverwaltung ab 25.000 € abschließe')]", "//h2[contains(text(),'Vermögens\u00ADverwalter für individuelle Bedürfnisse a')]",
            "//h2[contains(text(),'Besser unabhängig Geld anlegen')]", "//h2[contains(text(),'ETFs machen noch keine Vermögens\u00ADverwaltung')]",
            "//h2[contains(text(),'Menschliche Erfahrung entscheidet')]", "//h2[contains(text(),'Aktuelle Finanzfragen')]"};

    String[] links1 = {"/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/p[1]/a[1]", "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/p[1]/a[1]",
            "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/p[1]/a[1]", "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/p[1]/a[1]",
            "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/p[1]/a[1]", "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/p[1]/a[1]"};

    String[] links2 = {"http://18.185.161.25/investment", "http://18.185.161.25/managers", "http://18.185.161.25/products", "http://18.185.161.25/actual/uploads", "http://18.185.161.25/actual/key-figures",
            "http://18.185.161.25/actual"};

    String[] links3 = {"/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/h1[1]", "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/h1[1]", "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/h2[1]",
            "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/h1[1]", "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]", "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/h1[1]"};

    Home() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
    }

    boolean baseFlow() {
        this.openBasePage();
        this.checkURL();
        this.checkContent("//span[@class='banner__message-holder']");
        Driver.driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[5]/div[1]/div[1]/button[1]/span[1]/*")).click();
        this.checkLinks(links);
        this.transfer(links1, links2, links3);
        this.openLogin();


        return true;
    }

    void openBasePage() {
        this.driver.get("http://18.185.161.25/");
    }

    void checkURL() {
        if (driver.getCurrentUrl().equals("http://18.185.161.25/")) {
            System.out.println("Title is " + driver.getCurrentUrl());
        } else System.out.println("Invalid URL");
    }

    void checkContent(String a) {
        if (driver.findElement(By.xpath(a)) != null) {
            System.out.println("Correct banner");
        } else {
            System.out.println("Incorrect banner");
        }
    }

    void checkLinks(String[] array) {
        for (int i = 0; i < links.length; i++) {
            driver.findElement(By.xpath(links[i]));
        }
    }

    void transfer(String[] array1, String[] array2, String[] array3) {
        for (int i = 0; i < links.length; i++) {
            driver.findElement(By.xpath(links1[i])).click();

            if (driver.getCurrentUrl().equals(links2[i])) {
                System.out.println("Valid URL - " + driver.getCurrentUrl());
            } else System.out.println("Invalid URL");
            if (driver.findElement(By.xpath(links3[i])) != null) {
                System.out.println("Page is current");
            } else System.out.println("Page is not current!");
            driver.navigate().back();

        }

    }

    void openLogin() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
        if (driver.getCurrentUrl().equals("http://18.185.161.25/sign-in")) {
            System.out.println("Current URL");
        } else System.out.println("Invalid URL");

    }


}

