package com.example.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.saucedemo.abstractcomponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

    @FindBy(css = "[data-test='username']")
    private WebElement fieldUsername;

    @FindBy(css = "[data-test='password']")
    private WebElement fieldPassword;

    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        waitForElement(fieldUsername);
        fieldUsername.clear();
        fieldUsername.sendKeys(username);
    }

    public void setPassword(String password) {
        waitForElement(fieldPassword);
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
    }

    public void clickButtonLogin() {
        waitForElement(buttonLogin);
        buttonLogin.click();
    }

    public String getErrorMsg() {
        waitForElement(errorMsg);
        return errorMsg.getText().trim();
    }
}