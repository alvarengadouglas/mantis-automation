package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.TestRule;

public class CartPageElementMap extends CommonPage{

    @FindBy(id = "continue-shopping")
    protected WebElement btnContinueShopping;

    @FindBy(id = "checkout")
    protected WebElement btnCheckout;

    protected WebElement cartItem(String itemName){
        String xpath = "*//div[text()='" + itemName + "']";
        waitVisibilityOf(TestRule.getDriver().findElement(By.xpath(xpath)));
        return TestRule.getDriver().findElement(By.xpath(xpath));
    }
}
