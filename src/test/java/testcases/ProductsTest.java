package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import hook.TestBase;

public class ProductsTest extends TestBase {

    // ✅ Daftar produk yang ingin ditambahkan ke cart
    List<String> productList = List.of(
        "Sauce Labs Backpack",
        "Sauce Labs Bike Light",
        "Sauce Labs Bolt T-Shirt"
    );

    @Test
    public void addProductToCart() {
        for (String product : productList) {
            productsPage.addToCart(product);
            System.out.println("✅ Produk " + product + " ditambahkan ke keranjang.");
            boolean isProductStillVisible = productsPage.isProductVisibleToAdd(product);
            Assert.assertFalse(isProductStillVisible, "❌ Produk masih terlihat sebagai belum ditambahkan: " + product);
            
        }

        productsPage.buttonCart.click();
        
        System.out.println("🛒 Navigasi ke halaman keranjang.");
    }

    @Test
    public void removeProductToCart() {
        System.out.println("📌 Running removeProductToCart...");
        addProductToCart(); // tambahkan dulu

        for (String product : productList) {
            cartPage.removeFromCart(product);
            System.out.println("❌ Produk " + product + " dihapus dari keranjang.");
        }

        Assert.assertTrue(cartPage.isCartEmpty(), "❌ Keranjang tidak kosong setelah penghapusan!");
        System.out.println("✅ Semua produk berhasil dihapus dari keranjang.");
    }
}
