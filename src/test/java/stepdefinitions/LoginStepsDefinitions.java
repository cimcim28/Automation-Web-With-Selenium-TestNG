package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.example.saucedemo.pageobject.LoginPage;
import com.example.saucedemo.pageobject.ProductsPage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinitions {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginStepsDefinitions(){
        this.driver = Hooks.getDriver();  // ✅ Ambil driver setelah Hooks siap
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
    }

    @Given("The application has been launched")
    public void the_application_has_been_launched() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Landing page gagal");
    }

    @When("i enter {string} in field username")
    public void i_enter_in_field_username(String email) {
        loginPage.setEmail(email);
    }

    @And("i enter {string} in field password")
    public void i_enter_in_field_password(String password) {
        loginPage.setPassword(password);
    }

    @And("i click on login button")
    public void i_click_button_login() {
        loginPage.clickButtonLogin();
    }

    @Then("System should display page header 'PRODUCTS'")
    public void system_should_display_page_header_products() {
        Assert.assertEquals(productsPage.getPageTitle(), "Products", "Landing page gagal");
    }

    @Then("System should display {string} Error Message")
    public void system_should_display_error_message(String errorMsg) {
        Assert.assertEquals(loginPage.getErrorMsg(), errorMsg, "Error message salah");
    }
}
