package hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public static void setUp() {
        System.out.println("🔧 Cucumber setup...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver.set(new ChromeDriver(options));
        driver.get().manage().window().maximize();
        driver.get().get("https://www.saucedemo.com/");
    }

    @After
    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
