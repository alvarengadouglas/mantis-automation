package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.TestRule;

public class CommonPageElementMap {
    @FindBy(xpath = "*//span[@data-test='title']")
    protected WebElement headerTitle;
    @FindBy(id = "react-burger-menu-btn")
    protected WebElement menuHamburguer;

    @FindBy(id = "shopping_cart_container")
    protected WebElement cart;

    protected WebElement getAmountCartItens(String amount){
        return TestRule.getDriver().findElement(By.xpath("*//span[text()=\"" + amount + "\"]"));
    }

}
