package com.example.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.saucedemo.abstractcomponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ INISIALISASI PAGE FACTORY
    }

    @FindBy(css = "[data-test='firstName']")
    private WebElement fieldFirstName;

    @FindBy(css = "[data-test='lastName']")
    private WebElement fieldLastName;

    @FindBy(css = "[data-test='postalCode']")
    private WebElement fieldPostalCode;

    @FindBy(css = "[data-test='continue']")
    private WebElement buttonContinue;

    @FindBy(css = "[data-test='checkout']")
    private WebElement buttonCheckout;

    @FindBy(css = "[data-test='finish']")
    private WebElement buttonFinish;

    @FindBy(css = "[data-test='complete-header']")
    private WebElement messageHeader;

    @FindBy(css = "[data-test='inventory-item-name']")
    private WebElement firstItemInCart;  // 🔹 Ambil item pertama di keranjang

    public WebElement getFirstItemInCart() {
        waitForElementVisibility(firstItemInCart);
        return firstItemInCart;
    }
    public void getButtonCheckout() {
        buttonCheckout.click();
    }
    public String getMessageHeader() {
        return messageHeader.getText();
    }

    public void continueCheckOut(String firstName, String lastName, String postalCode) {
        waitForElementVisibility(fieldFirstName);
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        fieldPostalCode.sendKeys(postalCode);
        buttonContinue.click();
        waitForElementVisibility(buttonFinish);
        buttonFinish.click();
    }
}
