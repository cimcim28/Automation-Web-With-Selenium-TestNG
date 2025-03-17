package automation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.saucedemo.pageobject.LoginPage;
import com.example.saucedemo.pageobject.ProductsPage;

import hook.Hooks;

public class LoginTest extends Hooks {

    @Test
    public void testValidLogin() {
        WebDriver driver = Hooks.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAuth("standard_user", "secret_sauce");

        // Interaksi di ProductsPage
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
        
    }
}