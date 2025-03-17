package com.example.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.saucedemo.abstractcomponents.AbstractComponent;

public class LoginPage extends AbstractComponent { // Extend AbstractComponent

    @FindBy(css = "[data-test='username']")
    private WebElement fieldEmail;

    @FindBy(css = "[data-test='password']")
    private WebElement fieldPassword;

    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver); // Inisialisasi AbstractComponent
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAuth(String email, String password) {
        waitForElementVisibility(fieldEmail); // Gunakan method dari AbstractComponent
        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(password);
        buttonLogin.click();
    }
}