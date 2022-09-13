package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {

    IndexPage indexPage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyLogo(){

        indexPage = new IndexPage();
        boolean result = indexPage.validateLogo();

        Assert.assertTrue(result);
    }

    @Test
    public void verifyTitle() throws InterruptedException {

        //Thread.sleep(1000);
        String title = indexPage.getMyStoreTitle();
        Assert.assertEquals(title, "My Store");
    }

}
