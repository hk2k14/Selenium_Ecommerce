package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {

    IndexPage indexPage;

    SearchResultPage searchResultPage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void productAvailabilityTest(){

        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");

        boolean result = searchResultPage.isProductAvailable();

        Assert.assertTrue(result);
    }


}
