package steps;

import io.cucumber.java.pt.Quando;
import pages.InventoryPage;

public class InventorySteps {
    InventoryPage ip;

    @Quando("adiciono {string} produtos ao carrinho")
    public void adicionoProdutosAoCarrinho(String amountItem) {
        ip = new InventoryPage();
        ip.addItensToCart(Integer.parseInt(amountItem));
    }
}
