import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Onboarding {
    static WebDriver driver = Driver.driver;

    public void flowPortfolio (){
        buyPortfolio();
        suitability();
    }

    void buyPortfolio()
    {
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/investment")){
            driver.get("http://18.185.161.25/investment");
        }
        driver.findElement(By.xpath("//tr[1]//div[@class=\"buttons-container\"]//button")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/client/onboardings")){
            System.out.println("The onboardings page doesn't open after buying a portfolio, current URL"+ driver.getCurrentUrl());
            driver.get("http://18.185.161.25/client/onboardings");
        }
    }
    void suitability()
    {
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/client/onboardings")){
            driver.get("http://18.185.161.25/client/onboardings");
        }
        WebElement goToSuitability = driver.findElement(By.xpath("//div[@class=\"onboardings-list-container\"]//li"));
        goToSuitability.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.findElements(By.xpath("//p[1][@class=\"suitability-subtitle\"]")).size()!=0)
        {
            driver.findElement(By.xpath("//p[@class=\"max\"]")).click(); //1st q slider
            driver.findElement(By.xpath("//div[@class=\"question__steps-buttons\"]//button[2]")).click(); //next
            driver.findElement(By.xpath("//div[@class=\"jss228\"]")).click(); //open dropdown list of 2nd q
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//div[@role=\"document\"]//li[@data-value=\"Wealth preservation\"]")).click(); //select 1st item in the dropdown
            driver.findElement(By.xpath("//button[1][@type=\"button\" and @style=\"border-radius: 0px; box-shadow: none; font-family: Montserrat, sans-serif; font-size: 14px;\" ]")).click(); //press back
            driver.findElement(By.xpath("//div[@class=\"question__steps-buttons\"]//button[2]")).click(); //press next
            driver.findElement(By.xpath("//button[2][@type=\"button\" and @style=\"border-radius: 0px; box-shadow: none; font-family: Montserrat, sans-serif; font-size: 14px;\" ]")).click(); //next to the 3rd q

        }else System.out.println("The Suitability page is not opened!");
    }

}
