package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseClass {

    @FindBy(id="email")
    WebElement userName;

//    @FindBy(xpath = "//*[@id='email']")
//    WebElement userName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement signInBtn;

    // To Create new account

    @FindBy(id = "email_create")
    WebElement emailForNewAccount;

    @FindBy(name = "SubmitCreate")
    WebElement createNewAccountBtn;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public HomePage Login(String username, String pass) throws InterruptedException {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(userName));

        userName.sendKeys(username);
        password.sendKeys(pass);

        signInBtn.click();

        return new HomePage();
    }

    public AddressPage Login2(String username, String pass){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.visibilityOf(userName));

        userName.sendKeys(username);
        password.sendKeys(pass);

        signInBtn.click();

        return new AddressPage();
    }


    public AccountCreationPage createNewAccount(String email) throws InterruptedException {

        Actions actions = new Actions(driver);

        actions.sendKeys(emailForNewAccount,email);

        actions.scrollToElement(createNewAccountBtn).click();
//        Thread.sleep(1000);
//        emailForNewAccount.sendKeys(email);

//        Thread.sleep(1000);
//        createNewAccountBtn.click();

        return new AccountCreationPage();
    }


}
