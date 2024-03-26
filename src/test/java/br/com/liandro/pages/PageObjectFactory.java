package br.com.liandro.pages;

import br.com.liandro.pages.objects.*;
import br.com.liandro.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectFactory {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    private LoginPageObject loginPageObject;
    private ProductsPageObejct productsPageObejct;

    private ProductDetailsPageObject productDetailsPageObject;
    private ShoppingCartPageObject shoppingCartPageObject;
    private CheckoutPageObject checkoutPageObject;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
        webDriverWait = Driver.getWaitDriver();
        PageFactory.initElements(driver,this);
    }

    public LoginPageObject getLoginPageObject() {
        if(this.loginPageObject == null) {
            this.loginPageObject = new LoginPageObject(driver);
        }
        return loginPageObject;
    }

    public ProductsPageObejct getProductsPageObejct() {
        if(this.productsPageObejct == null) {
            this.productsPageObejct = new ProductsPageObejct(driver);
        }
        return productsPageObejct;
    }

    public ProductDetailsPageObject getProductDetailsPageObject() {
        if(this.productDetailsPageObject == null) {
            this.productDetailsPageObject = new ProductDetailsPageObject(driver);
        }
        return productDetailsPageObject;
    }

    public ShoppingCartPageObject getShoppingCartPageObject() {
        if(this.shoppingCartPageObject == null) {
            this.shoppingCartPageObject = new ShoppingCartPageObject(driver);
        }
        return shoppingCartPageObject;
    }

    public CheckoutPageObject getCheckoutPageObject() {
        if(this.checkoutPageObject == null) {
            this.checkoutPageObject = new CheckoutPageObject(driver);
        }
        return checkoutPageObject;
    }

}
