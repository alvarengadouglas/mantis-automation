package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class InventoryPage extends InventoryPageElementMap{

    public InventoryPage(){
        PageFactory.initElements(driver, this);
    }

    protected ArrayList getInventoryListItem(){
        waitVisibilityOf(inventoryItens.get(0));
        ArrayList inventoryItemNames = new ArrayList();
        for(WebElement item : inventoryItens){
            inventoryItemNames.add(item.getText());
        }
        return inventoryItemNames;
    }

    protected int checkItemLimit(int amountItens){
        if(amountItens < 1 || amountItens > 6){
           return 6;
        } else {
            return amountItens;
        }
    }

    public void addItensToCart(int amountItens) throws AssertionError{
        amountItens = checkItemLimit(amountItens);
        ArrayList itemList = getInventoryListItem();
        int amountItensInCart = 0;
        for (int x = 0; x < amountItens; x++){
            getBtnAddItem(itemList.get(x).toString()).click();
            amountItensInCart++;
            globalItensInCart.add(x, itemList.get(x).toString());
            Assert.assertTrue("Checando quantidade de itens no carrinho", checkAmountItensInCart(amountItensInCart));
        }
    }

    protected boolean checkAmountItensInCart(int expextedAmountItens){
        return String.valueOf(expextedAmountItens).equals(getAmountCartItens(String.valueOf(expextedAmountItens)).getText());
    }

}
