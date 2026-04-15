package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "C:\\Users\\HP\\IdeaProjects\\Versa_Cloud_ERP\\src\\test\\java\\Features\\LoginToVersaERP.feature",
    glue ={"Steps","Hooks"},
    publish = true,
plugin ={"pretty","html:target/cucumber-reports/VersaProductReports.html"}

)
public class VersaRunner extends AbstractTestNGCucumberTests {
}
