import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAllPortfolios {
    static WebDriver driver = Driver.driver;

    public void del()
    {
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/client/onboardings")){
            System.out.println("The invalid page opens "+driver.getCurrentUrl());
            driver.get("http://18.185.161.25/client/onboardings");
        }
        while (driver.findElements(By.xpath("//div[@class=\"onboardings-list-container\"]//li[1]//button")).size()!=0){
                driver.findElement(By.xpath("//div[@class=\"onboardings-list-container\"]//li[1]//button")).click();
                driver.findElement(By.xpath("//button[2][@type=\"button\" and @style=\"border-radius: 0px; box-shadow: none; font-family: Montserrat, sans-serif; font-size: 14px;\"]")).click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println("All portfolios are deleted");
        }

    }

