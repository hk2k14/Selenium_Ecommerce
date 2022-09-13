package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage extends BaseClass {

    @FindBy(xpath = "//a[contains(text(), 'Pay by bank wire')]")
    WebElement bankWireMethod;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    WebElement payByCheckMethod;

    public PaymentPage(){
        PageFactory.initElements(driver, this);
    }

    public OrderSummaryPage clickOnPayment(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.visibilityOf(bankWireMethod));

        bankWireMethod.click();
        return new OrderSummaryPage();
    }



}
