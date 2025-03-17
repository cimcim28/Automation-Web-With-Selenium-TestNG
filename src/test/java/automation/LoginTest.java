package automation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.example.saucedemo.pageobject.LoginPage;

import hook.Hooks;

public class LoginTest extends Hooks {

    @Test
    public void testValidLogin() {
        WebDriver driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAuth("standard_user", "secret_sauce");
        
    }
}