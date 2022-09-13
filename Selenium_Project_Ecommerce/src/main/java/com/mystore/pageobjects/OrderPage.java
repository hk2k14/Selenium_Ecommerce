package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage extends BaseClass {

    @FindBy(xpath = "//td[@class='cart_unit']/span/span")
    WebElement unitPrice;

    @FindBy(id = "total_price")
    WebElement totalPrice;

    @FindBy(xpath = "//*[text()='Proceed to checkout']")
    WebElement proceedToCheckout;

    public OrderPage(){
        PageFactory.initElements(driver, this);
    }

    public double getUnitPrice(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(unitPrice));

        String unitprice = unitPrice.getText();
        String unit = unitprice.replaceAll("[^a-zA-Z0-9]", "");

        double finalUnitPrice = Double.parseDouble(unit);

        return finalUnitPrice/100;
    }

    public LoginPage clickCheckout(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));

        proceedToCheckout.click();
        return new LoginPage();
    }

}
