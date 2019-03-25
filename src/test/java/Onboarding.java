import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Onboarding {
    static WebDriver driver = Driver.driver;

    public  void flowPortfolio() {
        buyPortfolio();
        suitability();
        one_four_of_onboarding();
    }

    void buyPortfolio() {
        if (!driver.getCurrentUrl().equals("http://18.185.161.25/investment")) {
            driver.get("http://18.185.161.25/investment");
        }
        driver.findElement(By.xpath("//tr[1]//div[@class=\"buttons-container\"]//button")).click();
////div[contains(text(),'You already have this product, you can invest more in the cockpit!')]
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
            wait(500);
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

    void one_four_of_onboarding (){
        wait(500);
        if (driver.findElements(By.xpath("//h4[@class=\"page-header\"]")).size()!=0){
            System.out.println("Are the Back and Skip buttons clickable? - "+driver.findElement(By.xpath("//div[@class=\"page-container-holder\"]//div[@class=\"page-container\"]//button[1]")).isEnabled()
                    +" "+driver.findElement(By.xpath("//div[@class=\"page-container-holder\"]//div[@class=\"page-container\"]//button[2]")).isEnabled());
            System.out.println("Are the Next button clickable? - "+driver.findElement(By.xpath("//div[@class=\"page-container-holder\"]//div[@class=\"page-container\"]//button[3]")).isEnabled());
            driver.findElement(By.xpath("//div[@class=\"page-container-holder\"]//div[@class=\"page-container\"]//button[3]")).click(); // go to the 1st step of onboarding
        }else System.out.println("Invalid onboarding page opens"+driver.getCurrentUrl());
        wait(500);
        driver.findElement(By.xpath("//h4[contains(text(),'Angaben zu Ihrer Person')]"));
        System.out.println("Are the Back and Skip and Next buttons clickable? - "+driver.findElement(By.xpath("//div[@class=\"page-container-holder\"]//div[@class=\"page-container\"]//button[1]")).isEnabled()
                +" "+driver.findElement(By.xpath("//div[@class=\"page-container-holder\"]//div[@class=\"page-container\"]//button[2]")).isEnabled()+" "+
                driver.findElement(By.xpath("//div[@class=\"page-container-holder\"]//div[@class=\"page-container\"]//button[3]")).isEnabled());

        System.out.println("1st page of Onboarding");

        WebElement skip = driver.findElement(By.xpath("//div[@class=\"prev-next\"]/button[2]"));
        skip.click();
        driver.findElement(By.xpath("//h6")); // check appears dialog window
        driver.findElement(By.xpath("//div[@role=\"dialog\"]//span[contains(text(), 'zurück')]")).click(); // close dialog
        driver.findElement(By.xpath("//span[contains(text(), 'zurück')]")).click(); //go to the previosu page
        driver.findElement(By.xpath("//div[@class=\"page-container-holder\"]//div[@class=\"page-container\"]//button[3]")).click(); //go to the onboarding

        selectItemInDropDown("//div[@class=\"form-holder\"]/div[1]/div[1]/div[1]", "//ul[@role=\"listbox\"]/li[1]");
        selectItemInDropDown("//div[@class=\"form-holder\"]/div[2]/div[1]/div[1]", "//ul[@role=\"listbox\"]/li[1]");
        selectItemInDropDown("//div[@class=\"form-holder\"]/div[5]/div[1]/div[1]","//div[@role=\"document\"]//li[2]");
        selectItemInDropDown("//div[@class=\"form-holder\"]/div[8]/div[1]/div[1]", "//div[@role=\"document\"]//li[2]");
        selectItemInDropDown("//div[@class=\"form-holder\"]/div[10]/div[1]/div[1]", "//div[@role=\"document\"]//li[2]");
        selectItemInDropDown("//div[@class=\"form-holder\"]/div[13]/div[1]/div[1]/div[1]/div[1]", "//div[@role=\"document\"]//li[1]");
        fillFiled("//input[@placeholder=\"Alle Vornamen aus dem Ausweisdokument sind anzugeben.\"]", "Vladislav");
        fillFiled("//div[@class=\"form-holder\"]/div[4]//input", "Nachname");
        fillFiled("//div[@class=\"form-holder\"]/div[6]//input", "Geburtsname");
        fillFiled("//div[@class=\"form-holder\"]/div[7]//input","01011995");
        fillFiled("//div[@class=\"form-holder\"]/div[9]//input", "Geburtsort");
        fillFiled("//div[@class=\"form-holder\"]/div[11]//input", "12345678909");
        fillFiled("//div[@class=\"form-holder\"]/div[14]//input","Pepname");
        fillFiled("//div[@class=\"form-holder\"]/div[15]//input", "Peplastname");
        fillFiled("//div[@class=\"form-holder\"]/div[16]//input", "Companyname");
        selectItemInDropDown("//div[@class=\"form-holder\"]/div[17]/div[1]/div[1]/div[1]", "//div[@role=\"document\"]//li[2]");
        driver.findElement(By.xpath("//button[3]")).click();

        System.out.println("2nd page of Onboarding");
        if (driver.findElements(By.xpath("//h3[text()[contains(.,'Angaben zu Ihrer Anschrift')]]")).size()!=0) {
            driver.findElement(By.xpath("//div[@class=\"prev-next\"]/button")).click(); //go to the 1st step
            driver.findElement(By.xpath("//button[3]")).click(); //go to the 2nd step
            fillFiled("//div[@class=\"form-holder\"]/div[1]/div/input", "Petra");
            fillFiled("//div[@class=\"form-holder\"]/div[2]/div/input", "1a");
            fillFiled("//div[@class=\"form-holder\"]/div[3]/div/input", "Kharkiv");
            fillFiled("//div[@class=\"form-holder\"]/div[4]/div/input", "addresszusatz");
            fillFiled("//div[@class=\"form-holder\"]/div[5]/div/input", "1212");
            //*[text()[contains(.,'ABC')]]




        }else System.out.println("Invalid step opens = "+driver.getCurrentUrl());










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
        boolean result2 = false;
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

    public void selectItemInDropDown (String dropdown, String item){
        driver.findElement(By.xpath(dropdown)).click();
        wait(500);
        driver.findElement(By.xpath(item)).click();
        wait(500);
    }

    public void fillFiled(String field, String data) {
       // if (driver.findElements(By.xpath(field)).size() != 0) {
        driver.findElement(By.xpath(field)).sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
           wait(200);
            driver.findElement(By.xpath(field)).sendKeys(data);
           wait(500);



      //  } else {
        //    driver.findElement(By.xpath(field)).sendKeys(data);
       //     wait(500);

      //  }
    }




}

