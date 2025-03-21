package com.example.saucedemo.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
    protected WebDriver driver;

    // Konstruktor untuk menerima driver
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    // Method untuk menunggu visibility element (menggunakan WebElement)
    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clearText(WebElement element) {
        element.clear();
    }

    public String getText(WebElement element) {
        return element.getText();
    }
}