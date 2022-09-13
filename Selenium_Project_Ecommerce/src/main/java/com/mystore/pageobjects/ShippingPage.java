package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingPage extends BaseClass {

    @FindBy(xpath = "//*[@id='cgv']")
    WebElement terms;

    @FindBy(xpath = "//*[@id='form']/p/button/span")
    WebElement proceedToCheckoutBtn;

    public ShippingPage(){
        PageFactory.initElements(driver, this);
    }

    public void checkTheTerms(){
        Duration duration = Duration.ofSeconds(40);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form']/div/p[2]/label"))).click();
        //terms.click();
    }

    public PaymentPage clickOnProceedToCheckout(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));

        proceedToCheckoutBtn.click();
        return new PaymentPage();
    }



}
