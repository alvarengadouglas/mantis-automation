package pages;

import org.openqa.selenium.support.PageFactory;

public class CartPage extends CartPageElementMap{

    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean checkItensInCart(){
        boolean isInCart = false;
        for(Object item: globalItensInCart){
            isInCart = cartItem(item.toString()).getText().equals(item.toString());
            if (!isInCart){
                return false;
            }
        }
        return isInCart;
    }

    public boolean checkVisibleElements(){
        waitVisibilityOf(cart);
        return btnCheckout.isDisplayed()
                && btnContinueShopping.isDisplayed()
                && cart.isDisplayed()
                && getAmountCartItens(String.valueOf(globalItensInCart.size())).isDisplayed();
    }

    public void checkout(){
        waitVisibilityOf(btnCheckout);
        btnCheckout.click();
    }


}
