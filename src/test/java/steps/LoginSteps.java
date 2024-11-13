package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.CommonPage;
import pages.LoginPage;
import util.TestRule;
import util.Utils;

public class LoginSteps {

    LoginPage lp;
    CommonPage cm;

    @Dado("que acesso a tela de login")
    public void que_acesso_a_tela_de_login() {
        String baseUrl = new Utils().getProperty("baseUrl");
        TestRule.openBrowser(baseUrl);
    }
    @Quando("realizo o login")
    public void realizo_o_login() {
        lp = new LoginPage();
        lp.login();
    }
    @Entao("sou direcionado para a tela de produtos")
    public void sou_direcionado_para_a_tela_de_produtos() {
        Assert.assertTrue(lp.isUserLogged());
    }

    @E("vou para o carrinho")
    public void vouParaOCarrinho() {
        cm = new CommonPage();
        cm.goToCart();

    }
}
