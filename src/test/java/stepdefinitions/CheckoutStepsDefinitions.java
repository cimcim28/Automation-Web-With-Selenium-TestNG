package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.example.saucedemo.pages.CheckOutPage;
import com.example.saucedemo.pages.LoginPage;
import com.example.saucedemo.pages.ProductsPage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepsDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckOutPage checkoutPage;

    public CheckoutStepsDefinitions() {
        this.driver = Hooks.getDriver();  // ✅ Ambil driver setelah Hooks siap
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.checkoutPage = new CheckOutPage(driver);
    }

    @Given("User navigates to application URL")
    public void user_navigates_to_application_url() {
        driver.get("https://www.saucedemo.com/");
    }

    @Given("the application has been launched")
    public void application_success_launched() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Landing page gagal");
    }

    @Given("User logged to website")
    public void buyer_logged_to_website() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickButtonLogin();
        Assert.assertEquals(productsPage.getPageTitle(), "Products", "Landing page gagal");
    }

    @When("User add product to Cart and checkout")
    public void buyer_add_product_to_cart() {
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.waitForElementVisibility(productsPage.buttonCart);
        productsPage.buttonCart.click();
        checkoutPage.getButtonCheckout();
    }

    @And("User add checkout information")
    public void buyer_add_checkout_information() {
        checkoutPage.continueCheckOut("John", "Doe", "123456");
    }

    @Then("User will see message overview order and on finish order")
    public void buyer_will_see_message_overview_order_and_on_finish_order(){
        Assert.assertEquals(checkoutPage.getMessageHeader(), "Thank you for your order!", "Checkout gagal");
    }

    @Then("User confirmation page THANKYOU FOR THE ORDER.")
    public void buyer_confirmation_page_thankyou_for_the_order() {
        System.out.println("Test berhasil: Pesanan telah selesai!");
    }
}
