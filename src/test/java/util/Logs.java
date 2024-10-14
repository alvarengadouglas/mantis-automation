package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Logs {
    public ExtentReports extent = new ExtentReports();
    ExtentTest et = null;

    String lineSeparator = "=========================================================";
    String div = "<div style='text-align:center; font-weight:bold;'>";
    String divError = "<div style='text-align:center;font-weight:bold;font-size: 16px; color:red;'>";
    String fechaDiv = "</div>";
    String quebraLibra = "<br>";
    String h1 = "<h1>#</h1>";
    String badge = "<span class='badge badge-info'>#</span>";

    String icon =
            "<span class=\"material-symbols-outlined\">\n" +
                    "#\n" +
                    "</span>";

    public void createReport(String reportName){

        ExtentSparkReporter spark = new ExtentSparkReporter("target/Reports/" + reportName + ".html");
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);
    }

    public void createTest(String testName){
        et = extent.createTest(testName);
    }

    public void logInfo(String messageLog){
        et.info(messageLog);
    }

    public void logInfoIcon(String materialIconeName, String messageLog){
        et.info(div + messageLog + " - " + icon.replace("#", materialIconeName) + fechaDiv);
    }

    public void logInfoBadge(String messageLog){
        et.info(div + h1.replace("#", badge.replace("#", messageLog))  + fechaDiv);
    }

    public void logInfoSeparator(String messageLog){
        et.info(div + lineSeparator + quebraLibra + messageLog + fechaDiv);
    }

    public void logPass(String messageLog){
        et.pass(messageLog);
    }

    public void logWarning(String messageLog){
        et.warning(messageLog);
    }

    public void logSkip(String messageLog){
        et.skip(messageLog);
    }

    public void logFail(String messageLog){
        et.fail(messageLog);
    }

    public void logFailSeparator(String messageLog){
        et.fail(divError + lineSeparator + quebraLibra + messageLog + fechaDiv);
    }

    public void logFail(Exception exception){
        et.fail(exception);
    }


    public void logPassPrint(String screenshotPath){
        et.pass(
            "Página carregada com sucesso",
            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
        );
    }

    public void logPassJson(String json){
        et.generateLog(Status.PASS, MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public void logInfoJson(String json){
        et.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public void logWarningJson(String json){
        et.warning(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public void logSkipJson(String json){
        et.skip(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public void logFailJson(String json){
        et.fail(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public void logError(AssertionError e) throws Exception {
        et.fail(e.getMessage());
        throw new Exception(e.getMessage());
    }

    public void logError(Exception e) throws Exception {
        et.fail(e.getMessage());
        throw new Exception(e.getMessage());
    }
}
