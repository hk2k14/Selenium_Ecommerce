package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {

    IndexPage indexPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void addToCartTest() throws InterruptedException {

        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        addToCartPage =  searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("1");
        addToCartPage.selectSize("M");
        Assert.assertTrue(addToCartPage.clickAddToCart());
    }

}
