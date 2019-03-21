import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Onboarding {
    static WebDriver driver = Driver.driver;

    public void flowPortfolio() {
        //  buyPortfolio();
        suitability();
    }

    void buyPortfolio() {
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/investment")) {
            driver.get("http://18.185.161.25/investment");
        }
        driver.findElement(By.xpath("//tr[1]//div[@class=\"buttons-container\"]//button")).click();
        wait(1000);
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/client/onboardings")) {
            System.out.println("The onboardings page doesn't open after buying a portfolio, current URL" + driver.getCurrentUrl());
            driver.get("http://18.185.161.25/client/onboardings");
        }
    }

    void suitability() {
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/client/onboardings")) {
            driver.get("http://18.185.161.25/client/onboardings");

        }
        WebElement goToSuitability = driver.findElement(By.xpath("//div[@class=\"onboardings-list-container\"]//li"));
        goToSuitability.click();
        wait(500);
        if (driver.findElements(By.xpath("//p[1][@class=\"suitability-subtitle\"]")).size() != 0) {


            WebElement previousStep = driver.findElement(By.xpath("//div[@class=\"question__steps-buttons\"]/button[1]"));

            driver.findElement(By.xpath("//p[@class=\"max\"]")).click(); //1st q slider
            nextStep(); //next
            driver.findElement(By.xpath("//div[@style=\"min-height: 0px; height: auto; transition-duration: 258ms;\"]/div/div/div/div")).click(); //open dropdown list of 2nd q
            wait(500);

            driver.findElement(By.xpath("//div[@role=\"document\"]//li[@data-value=\"Wealth preservation\"]")).click(); //select  item in the dropdown
            wait(500);

            nextStep(); //next to the 3rd q

            wait(500);
            driver.findElement(By.xpath("//table[1]//tr[1]/td[1]//input[@type=\"checkbox\"]")).click(); // select checkbox in the table
            wait(500);

            nextStep(); //go to the 4th step
            wait(500);
            driver.findElement(By.xpath("//table[1]//tr[9]//td[1]/div")).click(); //open the last dropdown list in the table
            wait(500);
            driver.findElement(By.xpath("//li[@data-value=\"3 years\"]/p[@class=\"menuBar\"]")).click(); //select itrem in the dropdown
            wait(500);
            nextStep(); //go to the 5th step
            wait(500);
            driver.findElement(By.xpath("//li[@class=\"rangeslider__label-item\" and @data-value=\"10000\"]")).click(); //set 5000 uevro
            wait(500);
            nextStep(); //go to the 6th step
            wait(500);
            driver.findElement(By.xpath("//input[@type=\"number\"]")).clear();
            driver.findElement(By.xpath("//input[@type=\"number\"]")).sendKeys("12"); // enter months number
            wait(500);
            nextStep();//go to the 7th step
            wait(500);
            driver.findElement(By.xpath("//div[@class=\"question\"]//button[1]/span[1]")).click(); //open the dropdownlist
            wait(500);
            driver.findElement(By.xpath("//ul[@role=\"menu\"]/li[5]")).click(); //select >500.000
            wait(500);
            nextStep(); //go to the 8th step
            wait(500);
            driver.findElement(By.xpath("//input[@id=\"number-input\"]")).sendKeys("100000"); //enter data euro
            wait(500);
            nextStep(); //go to the 9th step
            wait(500);
            for (int i = 0; i < 8; i++) {
                wait(500);
                previousStep();
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0, -700)", "");

            }
            for (int i = 0; i < 9; i++) {
                wait(500);
                nextStep();

            }//go to the next page


        } else System.out.println("The Suitability page is not opened!");
    }


    void wait(int a) {
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean nextStep() {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(By.xpath("//div[@class=\"question__steps-buttons\"]/button[2]")).click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public boolean previousStep() {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(By.xpath("//div[@class=\"question__steps-buttons\"]/button[1]")).click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }




}

