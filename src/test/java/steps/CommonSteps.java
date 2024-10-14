package steps;


import io.cucumber.java.pt.Dado;
import util.TestRule;

public class CommonSteps {

    @Dado("que acesso o ecommerce")
    public void acessarEcommerce(){
        String ecommerceUrl = "http://automationpractice.com";
        TestRule.openBrowser(ecommerceUrl);
    }

}
