package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.example.saucedemo.pageobject.CheckOutPage;
import com.example.saucedemo.pageobject.LoginPage;
import com.example.saucedemo.pageobject.ProductsPage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckOutPage checkoutPage;

    public CheckoutSteps() {
        this.driver = Hooks.getDriver();  // ✅ Ambil driver setelah Hooks siap
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.checkoutPage = new CheckOutPage(driver);
    }

    @Given("Buyer landing to ecommerce")
    public void buyer_landing_to_ecommerce() {
        driver.get("https://www.saucedemo.com/");
    }

    @Given("Buyer logged to website")
    public void buyer_logged_to_website() {
        loginPage.loginAuth("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getPageTitle(), "Products", "Landing page gagal");
    }

    @When("Buyer add product to Cart and checkout")
    public void buyer_add_product_to_cart() {
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.waitForElementVisibility(productsPage.buttonCart);
        productsPage.buttonCart.click();
        checkoutPage.getButtonCheckout();
    }

    @And("Buyer add checkout information")
    public void buyer_add_checkout_information() {
        checkoutPage.continueCheckOut("John", "Doe", "123456");
    }

    @Then("Buyer will see message overview order and on finish order")
    public void buyer_will_see_message_overview_order_and_on_finish_order(){
        Assert.assertEquals(checkoutPage.getMessageHeader(), "Thank you for your order!", "Checkout gagal");
    }

    @Then("Buyer confirmation page THANKYOU FOR THE ORDER.")
    public void buyer_confirmation_page_thankyou_for_the_order() {
        System.out.println("Test berhasil: Pesanan telah selesai!");
    }
}
