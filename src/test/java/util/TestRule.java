package util;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TestRule extends TestWatcher{
    static String currentFeatureName;

    Logs logs;

    @Getter
    public static WebDriver driver;

    public static String getDateNow(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return now.format(formatter).replaceAll(" ", "_").replaceAll("-", "_").replaceAll(":", "_");
    }

    public TestRule(){
        super();
    }

    @Override
    protected void starting(Description description){}

    @Before
    public void beforeScenario(Scenario scenario){
        if (currentFeatureName == null) {
            String featurePath = scenario.getUri().toString();
            currentFeatureName = featurePath.substring(featurePath.lastIndexOf("/") + 1);
            logs = new Logs();
            logs.createReport(currentFeatureName);
            currentFeatureName = null;
        }
        logs.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws Exception {
        if (scenario.isFailed()){
            logs.logPrintError(TestRule.getDriver(), getDateNow(), scenario);
        }else {
            logs.logPrintPass(TestRule.getDriver(), getDateNow());
        }

        logs.writeReport();

        if(driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws Exception {
        if (scenario.isFailed()){
            logs.logPrintError(TestRule.getDriver(), getDateNow(), scenario);
        }else {
            logs.logPrintPass(TestRule.getDriver(), getDateNow());
        }
    }

    protected void finished(Description description){
        super.finished(description);
    }

    public static void openBrowser(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.addArguments("start-maximized");
        chromeOpts.addArguments("--no-sandbox");
        chromeOpts.addArguments("--disable-dev-shm-usage");
        chromeOpts.addArguments("--headless");

        driver = new ChromeDriver(chromeOpts);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
        driver.navigate().to(url);
    }

    public static void openBrowserLogged(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.addArguments("start-maximized");
        chromeOpts.addArguments("--no-sandbox");
        chromeOpts.addArguments("--disable-dev-shm-usage");
        chromeOpts.addArguments("--headless");

        driver = new ChromeDriver(chromeOpts);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
        driver.navigate().to(url);

        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));
        wait.until(ExpectedConditions.urlContains(url));

        driver.manage().addCookie(new Cookie("session-username", "standard_user"));

        getDriver().navigate().to(url + "/inventory.html");
    }

}
