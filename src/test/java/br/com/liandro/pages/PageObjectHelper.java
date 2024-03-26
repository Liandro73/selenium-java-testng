package br.com.liandro.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectHelper extends PageObjectFactory {

    public PageObjectHelper(WebDriver driver) {
        super(driver);
    }

    protected void esperarElementoFicarVisivel(WebElement elemento) {
        webDriverWait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.isDisplayed();
    }

    protected void clicarNoElementoJS(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

}
