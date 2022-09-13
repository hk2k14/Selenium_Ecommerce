package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage extends BaseClass {

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(name = "group_1")
    WebElement size;

    @FindBy(xpath = "//span[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement checkoutBtn;

    public AddToCartPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterQuantity(String item_quantity) throws InterruptedException {

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(quantity));

        quantity.sendKeys(item_quantity);
    }

    public void selectSize(String size_value){

        Select select = new Select(size);
        select.selectByVisibleText(size_value);
    }

    public boolean clickAddToCart(){
        addToCartBtn.click();

        // 2.03
        return driver.getPageSource().contains("Product successfully added to your shopping cart");
    }

    public OrderPage proceedToCheckout(){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.visibilityOf(checkoutBtn));

        // If this did not work then refer 2.07
        checkoutBtn.click();
        return new OrderPage();
    }


}
