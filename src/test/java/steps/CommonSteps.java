package steps;


import io.cucumber.java.pt.Dado;
import util.TestRule;
import util.Utils;

public class CommonSteps {

    @Dado("que acesso o ecommerce logado")
    public void acessarEcommerceLogado(){
        String baseUrl = new Utils().getProperty("baseUrl");
        TestRule.openBrowserLogged(baseUrl);
    }

}
