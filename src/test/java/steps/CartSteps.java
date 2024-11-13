package steps;

import io.cucumber.java.pt.E;
import org.junit.Assert;
import pages.CartPage;

public class CartSteps {
    CartPage cp;

    @E("verifico os itens adicionados")
    public void verificoOsItensAdicionados() {
        cp = new CartPage();
        cp.goToCart();

        Assert.assertTrue("Checando navegação para página correta", cp.isInCartPage());
        Assert.assertTrue("Checando elementos visíveis", cp.checkVisibleElements());
        Assert.assertTrue("Checando itens adicionados ao carrinho", cp.checkItensInCart());

    }
}
