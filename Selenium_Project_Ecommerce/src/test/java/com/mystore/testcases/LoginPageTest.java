package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

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
    public void LoginTest() throws InterruptedException {
        indexPage = new IndexPage();

        loginPage = indexPage.clickOnSignIn();

        homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

        String actualURL = homePage.getCurrURL();
        String expectedURL = "http://automationpractice.com/index.php?controller=my-account";

        Assert.assertEquals(actualURL, expectedURL);
    }

}
