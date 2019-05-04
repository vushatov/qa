import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//PUSH ⇧⌘K - shift+cmd+k

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

        WebDriver driver = Driver.driver; // в главный класс


/*
        @BeforeAll //выполниться перед всем
        public void before() {
        }

        @AfterAll // выполниться после всего
        public void after() {
        }
        @BeforeEach   // выполняеться перед каждым тестовым методом
        public void setUp(){}

        @AfterEach// выполняеться после  каждого тестового метода
        public void tearDown(){}
    */
      /*  @Test
        public void method(){
            Assertions.assertTrue(1+1==2);
            Assertions.assertFalse(1+1==22);
            // Assertions.assertNull(0);
            //Assertions.assertNotNull(0);
            Assertions.assertEquals(10,51+5);
            Assertions.assertNotEquals(10, 11);

        } */



















        /////////////////////////////////депенданци для pom.xml
        /*
        <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>8</source>
                    <target>8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
    <dependencies>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
    </dependencies>
              */




        /*  обработка ввода!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         Scanner scanner = new Scanner(System.in);
        int i=0;
        int j=0;
        System.out.println("Введите количесво звезд в строке ");
        try {
            i = scanner.nextInt();
            System.out.println("Введите кол строк ");
            j = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Not number");
        }
         */



    }
}
