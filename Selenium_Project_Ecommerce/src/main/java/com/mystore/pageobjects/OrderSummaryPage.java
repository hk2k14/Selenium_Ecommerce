package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderSummaryPage extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement confirmOrderBtn;

    public OrderSummaryPage(){
        PageFactory.initElements(driver, this);
    }

    public OrderConfirmationPage clickOnConfirmBtn(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));

        confirmOrderBtn.click();
        return new OrderConfirmationPage();
    }



}
