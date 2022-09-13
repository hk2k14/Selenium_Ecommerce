package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    IndexPage indexPage;

    LoginPage loginPage;

    HomePage homePage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyWishList() throws InterruptedException {

        indexPage = new IndexPage();

        loginPage = indexPage.clickOnSignIn();

        homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
        boolean result = homePage.validateMyWishlist();

        Assert.assertTrue(result);
    }

    @Test
    public void verifyOrderHistory() throws InterruptedException {

        indexPage = new IndexPage();

        loginPage = indexPage.clickOnSignIn();

        homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
        boolean result = homePage.validateOrderHistory();

        Assert.assertTrue(result);
    }

}
