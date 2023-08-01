import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise2 {


    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://automationexercise.com");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void productTest(){

        WebElement products =driver.findElement(By.xpath("//a[@href='/products']"));
        products.click();

        WebElement allProductVerify =driver.findElement(By.xpath("//h2[@class='title text-center']"));

        Assert.assertTrue("All Product Sayfası Görünmüyor",allProductVerify.isDisplayed());

        WebElement searchBox =driver.findElement(By.xpath("//input[@name='search']"));
        searchBox.sendKeys("kıyafet");

        WebElement searchBoxClick =driver.findElement(By.xpath("//button[@id='submit_search']"
        ));
        searchBoxClick.click();

        WebElement searchedProducts =driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue("search products yazısı görünmüyor",searchedProducts.isDisplayed());

    }
}
