package hook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.example.saucedemo.pages.CheckOutPage;
import com.example.saucedemo.pages.LoginPage;
import com.example.saucedemo.pages.ProductsPage;

public class TestBase {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CheckOutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        System.out.println("🔄 Initializing WebDriver...");
        Hooks.setUp(); // Inisialisasi driver via Hooks
        this.driver = Hooks.getDriver();
        
        // Inisialisasi page objects
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.checkoutPage = new CheckOutPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("🛑 Closing WebDriver...");
        Hooks.tearDown();
    }
}
