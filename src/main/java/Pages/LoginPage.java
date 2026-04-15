package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

//locators
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    @FindBy(xpath="//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[contains(text(),'Skip')]")
    private WebElement skipButton;


    public LoginPage(WebDriver driver)
{
    PageFactory.initElements(driver,this);
    this.driver=driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

}
//Actions
public void enterUsername(String user) {
    wait.until(ExpectedConditions.visibilityOf(username));
    username.clear();
    username.sendKeys(user);
}

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(pass);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void skipPopupIfPresent() {
        try {
            if (wait.until(ExpectedConditions.visibilityOf(skipButton)).isDisplayed()) {
                skipButton.click();
            }
        } catch (Exception e) {
            System.out.println("No popup displayed");
        }
    }
}


