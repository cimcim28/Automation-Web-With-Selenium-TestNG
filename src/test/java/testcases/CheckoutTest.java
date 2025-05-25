package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import hook.TestBase;

public class CheckoutTest extends TestBase {

    @Test
    public void testCheckOutOrder() throws InterruptedException {
        System.out.println("📌 Running testCheckOutOrder...");

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickButtonLogin();
        Assert.assertEquals("Products", productsPage.getPageTitle());
        String productName = "Sauce Labs Bike Light";
        productsPage.addToCart(productName);
        System.out.println("✅ Produk " + productName + " ditambahkan ke keranjang.");
        productsPage.buttonCart.click();
        System.out.println("🛒 Navigasi ke halaman keranjang.");
        checkoutPage.getButtonCheckout();
        checkoutPage.continueCheckOut("John", "Doe", "123456");
        Assert.assertEquals("Thank you for your order!", checkoutPage.getMessageHeader());
        System.out.println("✅ Checkout berhasil!");
    }
}