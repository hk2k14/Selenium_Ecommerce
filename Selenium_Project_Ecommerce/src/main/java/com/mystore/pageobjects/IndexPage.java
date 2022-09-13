package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInBtn;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement logoElement;

    @FindBy(id="search_query_top")
    WebElement productSearchBox;

    @FindBy(name = "submit_search")
    WebElement searchButton;


    public IndexPage(){
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickOnSignIn(){

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(signInBtn));

        signInBtn.click();
        return new LoginPage();
    }

    public boolean validateLogo(){
        return logoElement.isDisplayed();
    }

    public String getMyStoreTitle(){
        String myStoreTitle = driver.getTitle();
        return myStoreTitle;
    }

    public SearchResultPage searchProduct(String productName){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(productSearchBox));

        productSearchBox.sendKeys(productName);
        searchButton.click();

        return new SearchResultPage();
    }

}
