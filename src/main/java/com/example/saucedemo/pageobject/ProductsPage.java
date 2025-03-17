package com.example.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.saucedemo.abstractcomponents.AbstractComponent;

public class ProductsPage extends AbstractComponent {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test='title']")
    private WebElement pageTitle;

    public String getPageTitle() {
        return pageTitle.getText();
    }

}
