package com.example.saucedemo.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.saucedemo.abstractcomponents.AbstractComponent;

public class ProductsPage extends AbstractComponent {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test='title']")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryItemNames;

    @FindBy(css = ".shopping_cart_link")
    public WebElement buttonCart;

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public List<WebElement> getInventoryItemNames() {
        return inventoryItemNames;
    }

    public WebElement getProductByName(String productName) {
        for (WebElement item : inventoryItemNames) {
            if (item.getText().equalsIgnoreCase(productName)) {
                return item;
            }
        }
        return null;
    }

    public void addToCart(String productName) {
        WebElement product = getProductByName(productName);
        if (product != null) {
            product.click();
        }
    }
}
