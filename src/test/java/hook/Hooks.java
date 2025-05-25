package hook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-features=AutofillServerCommunication");
        options.addArguments("--disable-features=PasswordManagerOnboarding");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--enable-automation");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        

        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));



        driver.set(new ChromeDriver(options));
        driver.get().manage().window().maximize();
        driver.get().get("https://www.saucedemo.com/");
    }

    @After
    public static void tearDown() {
        System.out.println("🛑 Closing Cucumber setup...");
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
