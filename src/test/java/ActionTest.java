import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v112.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.*;
import java.time.Duration;


public class ActionTest {


    //Mouse Action methods
    //actions.moveToElement()-- > üzerinde tut
    //        click -> tıkla
    //        clickAndHold --> tut çek bırak
    //        contextClick --> sağ click
    //        doubleClick --> cift tıklama

    static WebDriver driver;
    Actions action =new Actions(driver);
    @BeforeClass
    public static void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void loginTest() {

        WebElement signButton = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        action.click(signButton).perform();

        WebElement emailButton = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        action.click(emailButton).sendKeys("celebi@gmail.com").
                sendKeys(Keys.TAB).sendKeys("Clarusway@gmail.com").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        WebElement MrsButton = driver.findElement(By.xpath("//input[@value='Mrs']"));
        action.click(MrsButton).sendKeys(Keys.TAB).
                sendKeys("celebi@gmail.com").sendKeys(Keys.TAB).sendKeys("Clarusway1").
                sendKeys(Keys.TAB).sendKeys("25").sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).click().sendKeys(Keys.TAB).
                click().perform();



    }


    }


