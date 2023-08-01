import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FacebookTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com");

        WebElement email= driver.findElement(By.xpath("//input[@type='text']"));
        email.sendKeys("celebiiozgee@gmail.com");

        WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys("Clarusway1");
        WebElement submitButton= driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement warningLetter= driver.findElement(By.linkText("Hesabını bul ve giriş yap."));
        System.out.println(warningLetter.isDisplayed());
        System.out.println(warningLetter.getText());
        driver.close();


    }
}
