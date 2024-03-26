package br.com.liandro.pages.objects;

import br.com.liandro.pages.PageObjectHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageObject extends PageObjectHelper {

    public ProductDetailsPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy( id = "back-to-products" )
    private WebElement btnPaginaDetalhesProduto;

    @FindBy( xpath = "//button[text()='Add to cart']" )
    private WebElement btnAdicionarAoCarrinho;

    @FindBy( xpath = "//span[@class='shopping_cart_badge'][text()='1']" )
    private WebElement btnIrAoCarrinho;

    public void verificarSeEstouNaPaginaDetalhesProduto() {
        esperarElementoFicarVisivel(btnPaginaDetalhesProduto);
    }

    public void clicarNoBtnAdicionarAoCarrinho() {
        clicarNoElementoJS(btnAdicionarAoCarrinho);
    }

    public void clicarNoBtnIrAoCarrinho() {
        esperarElementoFicarVisivel(btnIrAoCarrinho);
        btnIrAoCarrinho.click();
    }

}
