package automation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.saucedemo.pageobject.CheckOutPage;
import com.example.saucedemo.pageobject.LoginPage;
import com.example.saucedemo.pageobject.ProductsPage;

import hook.Hooks;

public class CheckOutOrderTest extends Hooks {

    @Test
    public void testCheckOutOrder() throws InterruptedException {
        WebDriver driver = Hooks.getDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAuth("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(), "Products", "Gagal membuka halaman Products");

        String productName = "Sauce Labs Bike Light";
        productsPage.addToCart(productName);
        productsPage.buttonCart.click();

        CheckOutPage checkoutPage = new CheckOutPage(driver);
        checkoutPage.continueCheckOut("John", "Doe", "123456");
        Assert.assertEquals(checkoutPage.getMessageHeader(), "Thank you for your order!", "Checkout gagal");
    }
}
