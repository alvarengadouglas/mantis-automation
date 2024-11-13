package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.TestRule;

import java.math.BigDecimal;

public class CheckoutPage extends CheckoutElementMap{
    BigDecimal subTotalPrice = BigDecimal.ZERO;;
    BigDecimal taxPrice = BigDecimal.ZERO;;
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    protected boolean isThereMoreThanOneElement() {
        return priceList.size() != 1;
    }

    public boolean checkVisibleElements(){
        waitVisibilityOf(headerTitle);
        return headerTitle.isDisplayed()
                && btnContinue.isDisplayed()
                && headerTitle.getText().equals("Checkout: Your Information")
                && getAmountCartItens(String.valueOf(globalItensInCart.size())).isDisplayed();
    }

    public void continueCheckout(){
        waitVisibilityOf(firstName);
        firstName.sendKeys("Mock");
        lastName.sendKeys("Dos Santos");
        postalCode.sendKeys("88058-000");
        btnContinue.click();
    }

    protected BigDecimal getSubTotalPriceOfListItens(){
        waitVisibilityOf(priceList.get(0));
        if(!isThereMoreThanOneElement()){
            subTotalPrice = new BigDecimal(priceList.get(0).getText().replace("$", ""));
        }else {
            for(WebElement priceValue : priceList){
                BigDecimal value = new BigDecimal(priceValue.getText().replace("$", ""));
                subTotalPrice = subTotalPrice.add(value);
            }
        }
        return subTotalPrice;
    }

    protected BigDecimal getSubTotalPrice(){
        waitVisibilityOf(subTotalLabel);
        return new BigDecimal(subTotalLabel.getText().replace("Item total: $", ""));
    }

    protected BigDecimal getTaxPrice(){
        waitVisibilityOf(taxLabel);
        taxPrice = taxPrice.add(new BigDecimal(taxLabel.getText().replace("Tax: $", "")));
        return taxPrice;
    }

    protected BigDecimal getTotalPrice(){
        waitVisibilityOf(totalLabel);
        return new BigDecimal(totalLabel.getText().replace("Total: $", ""));
    }

    public boolean IsTheListPriceTheSameAsTheSubTotalPrice(){
        return getSubTotalPriceOfListItens().equals(getSubTotalPrice());
    }

    public boolean checkingTotalPrice(){
        return subTotalPrice.add(getTaxPrice()).equals(getTotalPrice());
    }

    public void finishOrder(){
        waitVisibilityOf(btnFinish);
        btnFinish.click();
    }

    public boolean checkCompleteOrder(){
        waitVisibilityOf(headerTitle);
        return headerTitle.getText().equals("Checkout: Complete!")
                && imgSuccess.isDisplayed()
                && completeHeader.isDisplayed()
                && completeHeader.getText().equals("Thank you for your order!")
                && completeText.isDisplayed()
                && completeText.getText().equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!")
                && btnBackHome.isDisplayed()
                && btnBackHome.getText().equals("Back Home")
                && TestRule.getDriver().getCurrentUrl().equals(utils.getProperty("baseUrl") + "/checkout-complete.html");
    }













}
