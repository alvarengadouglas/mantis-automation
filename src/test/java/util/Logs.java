package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Logs {
    ExtentReports extent = new ExtentReports();
    ExtentTest et;

    public void createReport(String reportName){
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Reports/" + reportName + ".html");
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);
    }

    public void writeReport(){
        extent.flush();
    }
    

    public void createTest(String testName){
        et = extent.createTest(testName);
    }

    public void logPrintPass(WebDriver driver, String screenShotName) throws IOException, InterruptedException {
        Utils.takeScreenshot(driver, screenShotName);
        et.pass(MediaEntityBuilder.createScreenCaptureFromPath("./" + screenShotName + ".png").build());
    }

    public void logPrintError(WebDriver driver, String screenshotName, Scenario scenario) throws IOException, Exception {
       Utils.takeScreenshot(driver, screenshotName);
        et.fail(MediaEntityBuilder.createScreenCaptureFromPath("./" + screenshotName + ".png").build());
        throw new Exception("Falha no cenário: " + scenario.getName());
    }
    
}
