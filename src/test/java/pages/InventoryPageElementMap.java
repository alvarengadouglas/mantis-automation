package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class InventoryPageElementMap extends CommonPage{
    @FindBy(xpath = "*//button[@data-test=\"add-to-cart-sauce-labs-backpack\"]")
    protected WebElement addBackback;

    @FindBy(xpath = "*//div[@data-test=\"inventory-item-name\"]")
    protected List<WebElement> inventoryItens;

    protected WebElement getBtnAddItem(String itemName){
        waitVisibilityOf(inventoryItens.get(0));

        return driver.findElement(By.xpath("*//button[@data-test='add-to-cart-"+ itemName.toLowerCase().replaceAll(" ", "-") + "']"));
    }


}
