package com.example.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.example.saucedemo.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeFromCart(String productName) {
    WebElement removeButton = driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//button"));
    removeButton.click();
    }
        
    public boolean isCartEmpty() {
        List<WebElement> items = driver.findElements(By.className("cart_item"));
        return items.isEmpty();
    }

}
