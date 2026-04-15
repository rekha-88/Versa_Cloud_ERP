package Hooks;

import LibraryFiles.DriverFactory;
import LibraryFiles.UtilityClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class VersaHooks {
    @Before
    public void openBrowser()
    {
        DriverFactory.initializeBrowser("Chrome");
    }

    @After
    public void closeBrowser(Scenario sce) throws IOException {
        if(sce.isFailed())
        {
            UtilityClass.captureSS(sce);
        }
        DriverFactory.driver.quit();
    }
}
