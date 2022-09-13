package com.mystore.pageobjects;

import com.beust.ah.A;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreationPage extends BaseClass {

    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement formTitleElement;

    public AccountCreationPage(){
        PageFactory.initElements(driver, this);
    }


    public boolean validateAccountCreatePage() throws InterruptedException {

//        Thread.sleep(2000);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        formTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='page-heading']")));
        return formTitleElement.isDisplayed();
    }



}
