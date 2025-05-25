package testcases;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import hook.TestBase;

public class LoginTest extends TestBase {
    @Test
    public void testLoginValid() {

        System.out.println("📌 Running testLoginValid...");

        fillForm(
            "standard_user",
            "secret_sauce"
        );

        String pageTitle = productsPage.getPageTitle();
        Assert.assertEquals(pageTitle, "Products", "❌ Gagal masuk ke halaman Products!");

    }

    @Test
    public void testLoginInvalid() {
        System.out.println("📌 Running testLoginInvalid...");

        List<List<String>> invalidCredentials = Arrays.asList(
            Arrays.asList("invalid_user", "wrong_password"),
            Arrays.asList("standard_user", "wrong_password"),
            Arrays.asList("locked_out_user", "secret_sauce"),
            Arrays.asList("", "secret_sauce")
        );

        for (List<String> credentials : invalidCredentials) {
            String username = credentials.get(0);
            String password = credentials.get(1);

            System.out.println("🔍 Testing with: " + username + " / " + password);


            fillForm(username, password);

            String errorMessage = loginPage.getErrorMsg();
            Assert.assertTrue(
                errorMessage.toLowerCase().contains("epic sadface") ||
                errorMessage.toLowerCase().contains("do not match"),
                "❌ Error message tidak muncul untuk kombinasi: " + username + " / " + password
            );
        }
    }

    public void fillForm(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickButtonLogin();
    }
}