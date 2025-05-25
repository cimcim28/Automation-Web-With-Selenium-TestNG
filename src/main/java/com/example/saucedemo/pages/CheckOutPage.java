package com.example.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.saucedemo.abstractcomponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

    @SuppressWarnings("unused")
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
    private WebElement firstItemInCart;

    @FindBy(css = "[data-test='error']")
    private WebElement messageError;


    public WebElement getFirstItemInCart() {
        waitForElementVisibility(firstItemInCart);
        return firstItemInCart;
    }
    public void clickButtonCheckout() {
        waitForElementVisibility(buttonCheckout);
        buttonCheckout.click();
    }
    public String getMessageHeader() {
        waitForElementVisibility(messageHeader);
        return messageHeader.getText();
    }

    public void inputFirstName(String firstName) {
        waitForElementVisibility(fieldFirstName);
        fieldFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        waitForElementVisibility(fieldLastName);
        fieldLastName.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        waitForElementVisibility(fieldPostalCode);
        fieldPostalCode.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        waitForElementVisibility(buttonContinue);
        buttonContinue.click();
    }

    public void clickFinishButton() {
        waitForElementVisibility(buttonFinish);
        buttonFinish.click();
    }

    public String getMsgError() {
        waitForElementVisibility(messageError);
        return messageError.getText();
    }
    
}
