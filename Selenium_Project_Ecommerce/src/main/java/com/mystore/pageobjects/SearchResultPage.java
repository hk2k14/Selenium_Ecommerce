package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage extends BaseClass {

    @FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[2]/h5/a")
    WebElement product;

    public SearchResultPage(){

        PageFactory.initElements(driver, this);
    }

    public boolean isProductAvailable(){
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(product));

        return product.isDisplayed();
    }

    public AddToCartPage clickOnProduct(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(product));

        product.click();
        return new AddToCartPage();
    }

}
