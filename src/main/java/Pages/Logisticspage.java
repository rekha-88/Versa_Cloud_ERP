package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static LibraryFiles.DriverFactory.driver;

public class Logisticspage {
    @FindBy(xpath = "//input[@id='shipAll']")
    private WebElement shipAllitems;

    @FindBy(xpath = "//a[contains(text(),'Post Shipment')]")
    private WebElement postShipment;

    @FindBy(xpath="//input[@id='package_tracking_number']")
    private WebElement shipmentTracking;

    @FindBy(xpath = "//div[@class='row-fluid content-row ']")
    private WebElement shipmentConfirmation;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public Logisticspage(WebDriver driver){
       PageFactory.initElements(driver,this);
   }
   public void clickOnshipAllitems(){
       shipAllitems.click();
       System.out.println("clicked on ship all available items");
   }
   public void clickonpostShipment() {

       wait.until(ExpectedConditions.visibilityOf(postShipment));
       wait.until(ExpectedConditions.elementToBeClickable(postShipment));
       postShipment.click();
   }
   public void handleAlertPopUp(){
       Alert alt=driver.switchTo().alert();
       alt.accept();

   }
   public void entershipmentTrackingvalue(String trackingNumber){
       shipmentTracking.sendKeys(trackingNumber);

   }
   public void verifyshipmentsucessmessage(){
      Boolean result= shipmentConfirmation.isDisplayed();
      System.out.println(result);
   }


}
