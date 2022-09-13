package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountCreationPageTest extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;

    AccountCreationPage accountCreationPage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyCreateAccountPageTest() throws InterruptedException {

        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();

        accountCreationPage = loginPage.createNewAccount("Hi@gmail.com");

        boolean result = accountCreationPage.validateAccountCreatePage();
        Assert.assertTrue(result);
    }

}
