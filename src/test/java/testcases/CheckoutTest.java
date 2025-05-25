package testcases;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import hook.TestBase;

public class CheckoutTest extends TestBase {

    // ✅ Daftar produk yang ingin ditambahkan ke cart
    List<String> productList = List.of(
        "Sauce Labs Backpack",
        "Sauce Labs Bike Light",
        "Sauce Labs Bolt T-Shirt"
    );

    // ✅ Data checkout tidak valid
    List<Map<String, String>> invalidCheckoutData = List.of(
        Map.of("firstName", "", "lastName", "Doe", "postalCode", "12345"),      // First name kosong
        Map.of("firstName", "Jane", "lastName", "", "postalCode", "12345"),     // Last name kosong
        Map.of("firstName", "Alex", "lastName", "Smith", "postalCode", ""),     // Postal code kosong
        Map.of("firstName", "", "lastName", "", "postalCode", "")               // Semua kosong
    );

    @Test
    public void testCheckoutProcess() {
        System.out.println("📌 Running testCheckOutOrder...");

        for (String product : productList) {
            productsPage.addToCart(product);
            System.out.println("✅ Produk " + product + " ditambahkan ke keranjang.");
        }

        productsPage.buttonCart.click();
        System.out.println("🛒 Navigasi ke halaman keranjang.");

        checkoutPage.clickButtonCheckout();

        // Gunakan data valid
        Map<String, String> validData = Map.of(
            "firstName", "John",
            "lastName", "Doe",
            "postalCode", "12345"
        );

        fillForm(validData);
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();

        Assert.assertEquals("Thank you for your order!", checkoutPage.getMessageHeader());
        System.out.println("✅ Checkout berhasil!");
    }

    @Test
    public void testCheckoutProcessInvalid() {
        System.out.println("📌 Running testCheckoutProcessInvalid...");

        for (Map<String, String> data : invalidCheckoutData) {
            productsPage.open(); // pastikan halaman di-reset setiap iterasi
            productsPage.addToCart("Sauce Labs Backpack");
            productsPage.buttonCart.click();
            checkoutPage.clickButtonCheckout();

            fillForm(data);
            checkoutPage.clickContinueButton();

            String errorMessage = checkoutPage.getMsgError();
            Assert.assertTrue(errorMessage.toLowerCase().contains("error"), "❌ Error tidak muncul untuk data: " + data);
            System.out.println("✅ Validasi error tampil sesuai ekspektasi untuk data: " + data);
        }
    }

    public void fillForm(Map<String, String> data) {
        checkoutPage.inputFirstName(data.get("firstName"));
        checkoutPage.inputLastName(data.get("lastName"));
        checkoutPage.inputPostalCode(data.get("postalCode"));
    }
}