package automation;
import org.testng.Assert;
import org.testng.annotations.Test;

import hook.TestBase;

public class LoginTest extends TestBase {
    @Test
    public void testValidLogin() {
        System.out.println("📌 Running testValidLogin...");

        // 🔹 Lakukan login
        loginPage.setEmail("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickButtonLogin();

        // 🔹 Verifikasi URL setelah login
        String currentUrl = driver.getCurrentUrl();
        System.out.println("🔍 Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("inventory.html"), "❌ URL tidak sesuai setelah login!");

        // 🔹 Verifikasi halaman berhasil masuk ke "Products"
        String pageTitle = productsPage.getPageTitle();
        Assert.assertEquals(pageTitle, "Products", "❌ Gagal masuk ke halaman Products!");
    }
}