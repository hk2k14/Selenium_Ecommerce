package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {

    SearchResultPage searchResultPage;

    IndexPage indexPage;

    AddToCartPage addToCartPage;

    OrderPage orderPage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyUnitPrice() throws InterruptedException {

        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");

        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectSize("M");
        addToCartPage.clickAddToCart();

        orderPage = addToCartPage.proceedToCheckout();

        Double unitPrice = orderPage.getUnitPrice();
        System.out.println(unitPrice);
        Assert.assertEquals(unitPrice, 16.51);
    }

}
