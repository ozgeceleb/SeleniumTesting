import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise {

   static WebDriver driver =new ChromeDriver();
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com");
    }
    @AfterClass
    public static void tearDown(){
         driver.close();
    }
    @Test
    public void hometest(){

        WebElement homePage= driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        homePage.isDisplayed();

        Assert.assertTrue("Home Page sayfası değildir",homePage.isDisplayed());

    }
    @Test
    public void logintest(){
        WebElement signUp =driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUp.click();

        WebElement loginLetter =driver.findElement(By.xpath("//div[@class='login-form']"));

        Assert.assertTrue("Yazı görünmüyor",loginLetter.isDisplayed());

        WebElement email =driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("ahmet@nehaber.com");

        WebElement password =driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");

        WebElement loginButton =driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        WebElement verify =driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue("yazı görünmüyor",verify.isDisplayed());
        System.out.println(verify.getText());

    }
}
