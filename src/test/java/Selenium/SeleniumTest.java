package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class SeleniumTest {
    public void Login() throws InterruptedException {
        System.setProperty("webdriver.edge.driver",
                "D:\\webdriver\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        input1.sendKeys("admin");
        Thread.sleep(500);
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        input2.sendKeys("admin123");
        Thread.sleep(500);
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        driver.close();
    }
}
