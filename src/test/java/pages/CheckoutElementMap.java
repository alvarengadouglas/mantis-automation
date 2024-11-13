package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutElementMap extends CommonPage{

    @FindBy(id = "first-name")
    protected WebElement firstName;

    @FindBy(id = "last-name")
    protected WebElement lastName;

    @FindBy(id = "postal-code")
    protected WebElement postalCode;

    @FindBy(id = "continue")
    protected WebElement btnContinue;

    @FindBy(xpath = "*//div[@data-test=\"cart-list\"]//div//div[@class=\"cart_item_label\"]//div//div[@data-test=\"inventory-item-price\"]")
    List<WebElement> priceList; //= TestRule.getDriver().findElements(By.xpath("*//div[@data-test=\"cart-list\"]//div//div[@class=\"cart_item_label\"]//div//div[@data-test=\"inventory-item-price\"]"));

    @FindBy(id = "finish")
    protected WebElement btnFinish;

    @FindBy(xpath = "*//div[@data-test=\"subtotal-label\"]")
    protected WebElement subTotalLabel;

    @FindBy(xpath = "*//div[@data-test=\"tax-label\"]")
    protected WebElement taxLabel;

    @FindBy(xpath = "*//div[@data-test=\"total-label\"]")
    protected WebElement totalLabel;

    @FindBy(xpath = "*//img[@data-test=\"pony-express\"]")
    protected WebElement imgSuccess;

    @FindBy(xpath = "*//h2[@data-test=\"complete-header\"]")
    protected WebElement completeHeader;

    @FindBy(xpath = "*//div[@data-test=\"complete-text\"]")
    protected WebElement completeText;

    @FindBy(id = "back-to-products")
    protected WebElement btnBackHome;


}
