package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.apache.hc.core5.http.HttpHost;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//span[text()='My wishlists']")
    WebElement myWishList;

    @FindBy(xpath = "//span[text()='Order history and details']")
    WebElement orderHistory;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }


    public boolean validateMyWishlist(){
        return myWishList.isDisplayed();
    }

    public boolean validateOrderHistory(){
        return orderHistory.isDisplayed();
    }

    public String getCurrURL(){

        String homePageURL = driver.getCurrentUrl();
        return homePageURL;
    }


}
