package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class OrderConfirmationPage extends BaseClass {


    @FindBy(xpath = "//p/strong[contains(text(), 'Your order on My Store is complete')]")
    WebElement confirmMsg;

    public OrderConfirmationPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateConfirmMsg(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait( driver, duration);

        wait.until(ExpectedConditions.elementToBeClickable(confirmMsg));

        return confirmMsg.getText();
    }

}
