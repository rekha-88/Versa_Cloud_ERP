package LibraryFiles;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityClass {
    public static void captureSS(Scenario sce) throws IOException {
        // Capture screenshot as file
        File srcFileName= ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.FILE);

        // Create timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        // Clean scenario name (remove spaces)
        String scenarioName = sce.getName().replaceAll(" ", "_");

        // Screenshot file path
        String destPath = "./Screenshots/" + scenarioName + "_" + timestamp + ".png";
        File destFileName=new File(destPath);

        FileHandler.copy(srcFileName,destFileName);
    }
}
