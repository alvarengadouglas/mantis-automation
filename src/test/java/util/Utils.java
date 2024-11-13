package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    protected static void setDriverByOS(){
        String driverPath = "src/test/resources/drivers/";
        if(System.getProperty("os.name").contains("Windows")){
            driverPath = driverPath + "chromedriver.exe";
        }else{
            driverPath = driverPath + "chromedriver";
        }
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    public String getProperty(String property) {
        Properties props = new Properties();
        try {
            FileReader stagingPropsReader = new FileReader("src/test/resources/tests.properties");
            props.load(stagingPropsReader);
            stagingPropsReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de properties nao encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Falha ao carregar as propriedades " + e.getMessage());
        }
        return props.getProperty(property);
    }

    static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException, InterruptedException {
        Thread.sleep(1000);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        boolean runningOnServer = Boolean.parseBoolean(new Utils().getProperty("running-on-server"));
        String directory = "target/Reports/" + screenshotName + ".png";
        Files.copy(source.toPath(), Paths.get(directory));
        return directory;
    }

}
