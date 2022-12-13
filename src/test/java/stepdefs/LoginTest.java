package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver ;
    private String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Given("user sedang berada di halaman login")
    public void user_sedang_berada_di_halaman_login() {
        System.setProperty("webdriver.edge.driver",
                "D:/webdriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @When("memasukan username {string}")
    public void memasukan_username(String string) {
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys(string);
    }

    @When("memasukan password {string}")
    public void memasukan_password(String string) {
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys(string);
    }

    @When("menekan tombol login")
    public void menekan_tombol_login() {
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
    }

    @Then("user berhasil masuk dahboard")
    public void user_berhasil_masuk_dahboard() {
        WebElement alert = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        String expected = "Dashboard";
        assertEquals(alert.getText(), expected);
        driver.quit();
    }

    @Then("user gagal masuk dahboard")
    public void user_gagal_masuk_dahboard() {
        WebElement alert = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        String expected = "Invalid credentials";
        assertEquals(alert.getText(),expected);
        driver.quit();
    }
}
