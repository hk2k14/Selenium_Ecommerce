package com.mystore.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static Properties prop;

  //  public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/Configuration/Config.properties");
            prop.load(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void launchApp() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }


    //WebDriverManager.chromedriver().setup();

//        String browserName = prop.getProperty("browser");
//
//        if (browserName.contains("Chrome")) {
//            System.setProperty("webdriver.chrome.driver","/Users/h0k033z/Documents/Drivers/chromedriver");
//            driver = new ChromeDriver();
//        }
//       Duration duration = Duration.ofSeconds(5l);
//
//       driver.manage().timeouts().implicitlyWait(duration);
//       driver.manage().timeouts().pageLoadTimeout(duration);
//       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//       driver.get(prop.getProperty("url"));
//       new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(By.cssSelector("element_css"))).click();
}
