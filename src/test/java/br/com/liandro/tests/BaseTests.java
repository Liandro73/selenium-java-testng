package br.com.liandro.tests;

import br.com.liandro.pages.PageObjectFactory;
import br.com.liandro.pages.objects.*;
import br.com.liandro.utils.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class BaseTests {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    protected PageObjectFactory pageObjectFactory;
    protected LoginPageObject loginPageObject;
    protected ProductsPageObejct productsPageObejct;
    protected ProductDetailsPageObject productDetailsPageObject;
    protected ShoppingCartPageObject shoppingCartPageObject;
    protected CheckoutPageObject checkoutPageObject;

    @BeforeMethod
    public void goTo() {
        Driver.startDriver();
        driver = Driver.getDriver();
        webDriverWait = Driver.getWaitDriver();
        this.pageObjectFactory = new PageObjectFactory(driver);
        this.loginPageObject = pageObjectFactory.getLoginPageObject();
        this.productsPageObejct = pageObjectFactory.getProductsPageObejct();
        this.productDetailsPageObject = pageObjectFactory.getProductDetailsPageObject();
        this.shoppingCartPageObject = pageObjectFactory.getShoppingCartPageObject();
        this.checkoutPageObject = pageObjectFactory.getCheckoutPageObject();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void screenshot() {
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        String timeNowFormated = timeNow.toString()
                .replace(":", ".")
                .replace(" ", "_");
        File evidence = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.moveFile(evidence, new File("target/screenshots/_screenshot_" + timeNow + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public static void tearDown() {
        Driver.stopApp();
    }

}
