package com.example.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(css = "span.title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryItemNames;

    @FindBy(css = ".shopping_cart_link")
    public WebElement buttonCart;

    public String getPageTitle() {
        waitForElementVisibility(pageTitle);  // 🔥 Tunggu elemen muncul
        return pageTitle.getText().trim();
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
    for (WebElement item : inventoryItems) {
        WebElement nameElement = item.findElement(By.className("inventory_item_name"));
        if (nameElement.getText().equalsIgnoreCase(productName)) {
            WebElement addToCartButton = item.findElement(By.cssSelector(".btn_inventory")); // 🔥 Cari tombol Add to Cart dalam produk yang sesuai
            addToCartButton.click();
            System.out.println("✅ Produk '" + productName + "' berhasil ditambahkan ke keranjang.");
            return;
        }
    }
    System.out.println("❌ Produk '" + productName + "' tidak ditemukan.");
    }

    public void open() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public boolean isProductVisibleToAdd(String productName) {
        try {
            WebElement addButton = driver.findElement(
                By.xpath("//div[@class='inventory_item']//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']")
            );
            return addButton.isDisplayed(); // masih muncul tombol Add to cart?
        } catch (NoSuchElementException e) {
            return false; // tidak ada tombol 'Add to cart' berarti sudah ditambahkan
        }
    }
    

}
