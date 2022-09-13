package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.apache.poi.ss.formula.functions.Index;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {

    IndexPage indexPage;

    AddToCartPage addToCartPage;

    SearchResultPage searchResultPage;

    OrderPage orderPage;

    LoginPage loginPage;

    AddressPage addressPage;

    ShippingPage shippingPage;

    PaymentPage paymentPage;

    OrderSummaryPage orderSummaryPage;

    OrderConfirmationPage orderConfirmationPage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void endToEnd() throws InterruptedException {

        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");

        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectSize("M");
        addToCartPage.clickAddToCart();

        orderPage = addToCartPage.proceedToCheckout();
        loginPage = orderPage.clickCheckout();

        addressPage = loginPage.Login2(prop.getProperty("username"), prop.getProperty("password"));

        shippingPage = addressPage.clickOnCheckOut();

       Thread.sleep(4000);
        shippingPage.checkTheTerms();
        paymentPage = shippingPage.clickOnProceedToCheckout();
        orderSummaryPage = paymentPage.clickOnPayment();

        orderConfirmationPage = orderSummaryPage.clickOnConfirmBtn();

        String actual = orderConfirmationPage.validateConfirmMsg();
        String expected = "Your order on My Store is complete.";

        Assert.assertEquals(actual, expected);
    }

}
