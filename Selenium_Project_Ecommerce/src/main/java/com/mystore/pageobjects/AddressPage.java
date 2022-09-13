package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage extends BaseClass {

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement proceedToCheckout;

    public AddressPage(){
        PageFactory.initElements(driver, this);
    }

    public ShippingPage clickOnCheckOut(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));

        proceedToCheckout.click();
        return new ShippingPage();
    }

}
