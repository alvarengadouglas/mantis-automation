package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMap extends CommonPage {
    @FindBy(id = "user-name")
    protected WebElement username;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(id = "login-button")
    protected WebElement btnLogin;
}
