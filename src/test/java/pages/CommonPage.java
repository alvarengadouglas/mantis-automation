package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestRule;
import util.Utils;

import java.util.ArrayList;

public class CommonPage extends CommonPageElementMap{

    protected Utils utils = new Utils();

    protected static ArrayList globalItensInCart = new ArrayList();

    public WebDriver driver = TestRule.getDriver();

    public CommonPage(){
        PageFactory.initElements(driver, this);
    }

    protected void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    protected void waitVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void goToCart(){
        waitVisibilityOf(cart);
        cart.click();
    }

    public boolean isInCartPage(){
        waitVisibilityOf(headerTitle);
        return driver.getCurrentUrl().equals(utils.getProperty("baseUrl") + "/cart.html")
                && headerTitle.getText().equals("Your Cart");
    }


}
