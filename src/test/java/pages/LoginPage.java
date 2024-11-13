package pages;

import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginPageElementMap{


    public LoginPage(){
        PageFactory.initElements(driver, this);
    };

    public void login(){
        String user = utils.getProperty("user-name");
        String pass = utils.getProperty("password");

        username.sendKeys(user);
        password.sendKeys(pass);
        btnLogin.click();
    }

    public boolean isUserLogged(){
        waitVisibilityOf(cart);
        return driver.getCurrentUrl().equals(utils.getProperty("baseUrl") + "/inventory.html")
            && cart.isDisplayed()
            && menuHamburguer.isDisplayed();
    }

}
