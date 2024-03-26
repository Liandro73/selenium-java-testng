package br.com.liandro.pages.objects;

import br.com.liandro.pages.PageObjectHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPageObject extends PageObjectHelper {

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy( xpath = "//span[text()='Your Cart']" )
    private WebElement textoPaginaCarrinho;

    @FindBy( id = "checkout" )
    private WebElement btnCheckout;

    public void verificarSeEstouNaPaginaCarrinho() {
        esperarElementoFicarVisivel(textoPaginaCarrinho);
    }

    public void clicarNoBtnCheckout() {
        btnCheckout.click();
    }

}
