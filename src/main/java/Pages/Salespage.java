package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Salespage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//a[@title='Sales']")
    private WebElement salesMenu;

    @FindBy(xpath = "//a[contains(@class,'new-so-order')]")
    private WebElement newSalesOrder;

    @FindBy(xpath = "//span[@id='customerdd']//input")
    private WebElement customerField;

    @FindBy(xpath = "//input[@value='Assign Order Number']")
    private WebElement assignOrderNumberButton;

    @FindBy(xpath = "//p[text()='Order Successfully Created']")
    private WebElement ordersuccess;

    @FindBy(xpath = "//input[@placeholder='Search for product or service']")
    private WebElement productorservice;

    @FindBy(xpath = "//input[@id='order_item_per_unit_cost']")
    private WebElement price;

    @FindBy(xpath = "//input[@id='order_item_quantity']")
    private WebElement QTY;

    @FindBy (xpath = "//input[@id='create_button']")
    private WebElement createButton;

    @FindBy(xpath = "//a[@id='ship_order_btn']")
    private WebElement shipOrderButton;


    public Salespage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //click on sales menu
    public void clickSales() {
        wait.until(ExpectedConditions.elementToBeClickable(salesMenu)).click();

    }

    //click on new sale order
    public void clickNewSalesOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(newSalesOrder)).click();
    }

    // as per video AJAX handling
    public void selectCustomer(String customerName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(customerField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(customerField)).clear();

        String partialText = customerName.substring(0, 3);
        customerField.sendKeys(partialText);
       /* List<WebElement> options = wait.until(driver ->
                driver.findElements(By.xpath("//li[contains(@class,'ui-menu-item')]")));*/
        Thread.sleep(2000);
        Actions act=new Actions(driver);
        act.sendKeys(Keys.ARROW_DOWN).perform();
        act.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

    }
    //assignOrderNumberButton
    public void assignOrderNumberButton(){
        wait.until(ExpectedConditions.elementToBeClickable(assignOrderNumberButton)).click();
    }

    public boolean isordercreated(){
        try {
            return wait.until(ExpectedConditions.visibilityOf(ordersuccess)).isDisplayed();

        } catch (Exception e) {
            System.out.println("order success message not visible");
            return false;
        }
    }
    //product or service
    public void productorservice(String productname) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(productorservice)).click();
        wait.until(ExpectedConditions.elementToBeClickable(productorservice)).clear();

        String partialText = productname.substring(0, 2);
        productorservice.sendKeys(partialText);

       Thread.sleep(3000);
        Actions act=new Actions(driver);
        for(int i=1;i<=0;i--)
        {
            act.sendKeys(Keys.ARROW_DOWN).perform();

        }
        act.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);


    }
    public void enterPrice(String pricevalue){
        price.clear();
        price.sendKeys(pricevalue);
        System.out.println("amount should be 20");
         }

    public void clickOncreateButton(){
        createButton.click();
        System.out.println("clicked on create button");
    }

    public void clickshipOrderButton(){
        shipOrderButton.click();
    }
}