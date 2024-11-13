package steps;


import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutSteps {
    CheckoutPage cp;
    CartPage cartPage;

    @E("concluo a etapa de checkout")
    public void concluoAEtapaDeCheckout() {
        cartPage = new CartPage();
        cartPage.checkout();
        cp = new CheckoutPage();

        Assert.assertTrue("Checando elementos visíveis na tela", cp.checkVisibleElements());

        cp.continueCheckout();
        Assert.assertTrue("Checando se o preço da lista somada é igual ao preço no subtotal", cp.IsTheListPriceTheSameAsTheSubTotalPrice());
        Assert.assertTrue("Checando se o preço da lista + taxa é igual ao preço total", cp.checkingTotalPrice());

        cp.finishOrder();
    }

    @Entao("a compra deve ser realizada com sucesso")
    public void aCompraDeveSerRealizadaComSucesso() {
        Assert.assertTrue("Checando conclusão da compra", cp.checkCompleteOrder());
    }
}
