package Steps;

import LibraryFiles.DriverFactory;
import Pages.LoginPage;
import Pages.Logisticspage;
import Pages.Salespage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Versa_Cloud_ERP_Steps {

    LoginPage login=new LoginPage(DriverFactory.driver);

    Salespage sales=new Salespage(DriverFactory.driver);

    Logisticspage logistic=new Logisticspage(DriverFactory.driver);

    //WebDriverWait wait = new WebDriverWait(DriverFactory.driver, Duration.ofSeconds(10));

    @Given("User is on Versa Cloud ERP login page")
    public void user_is_on_versa_cloud_erp_login_page() {
        DriverFactory.driver.get("https://www8.versaclouderp.com");


    }
    @When("User enter valid username as {string}")
    public void user_enter_valid_username_as(String username) {
        login.enterUsername(username);

    }
    @When("User enter valid password as {string}")
    public void user_enter_valid_password_as(String password) {
        login.enterPassword(password);

    }
    @When("User click on loginButton")
    public void user_click_on_login_button() {
        login.clickLogin();

       }
    @Then("sales menu should be visible")
    public void sales_menu_should_be_visible() {
        login.skipPopupIfPresent();
    }
        @When("User clicks on Sales menu")
        public void user_clicks_on_sales_menu() {
        sales.clickSales();

        }
        @When("User clicks on New Sales order")
        public void user_clicks_on_new_sales_order() {
            sales.clickNewSalesOrder();
        }
        @When("User selects customer name as {string}")
        public void user_selects_customer_name_as(String customername) throws InterruptedException {
        sales.selectCustomer(customername);

        }

    @When("User clicks on assign order number button")
    public void user_clicks_on_assign_order_number_button() {
        sales.assignOrderNumberButton();

            }
    @Then("order should be created successfully")
    public void order_should_be_created_successfully() {
        Assert.assertTrue(sales.isordercreated(),"order not created");

    }

    @When("User enters product or service name as {string}")
    public void user_enters_product_or_service_name_as_100ra_lh_s_r_sj_clips(String productname) throws InterruptedException {

       sales.productorservice(productname);
    }
    @When("User enters unit price as {string}")
    public void user_enters_unit_price_as(String pricevalue) {
        sales.enterPrice(pricevalue);

    }

    @When("User clicks on create button")
    public void user_clicks_on_create_button() throws InterruptedException {
        sales.clickOncreateButton();


            }
    @When("User clicks on Ship order button")
    public void user_clicks_on_ship_order_button() {
        sales.clickshipOrderButton();

            }
    @When("User clicks on ship All available items")
    public void user_clicks_on_ship_all_available_items() {
        logistic.clickOnshipAllitems();

    }
    @When("User clicks on post shipment button")
    public void user_clicks_on_post_shipment_button() throws InterruptedException {
        logistic.clickonpostShipment();
          }
    @When("User clicks on alert pop up message")
    public void user_clicks_on_alert_pop_up_message() {
        logistic.handleAlertPopUp();

    }
    @And("User enters shipment tracking no as {string}")
    public void userEntersShipmentTrackingNoAs(String trackingNumber) {
        logistic.entershipmentTrackingvalue(trackingNumber);

    }
    @When("Again User clicks on post shipment button")
    public void again_user_clicks_on_post_shipment_button(){

        logistic.clickonpostShipment();
           }
    @Then("Shipment successful message should be visible")
    public void shipment_successful_message_should_be_visible() {
        logistic.verifyshipmentsucessmessage();
         }

    @And("user wait for {int} sec")
    public void userWaitForSec(int int1) throws InterruptedException {
        Thread.sleep(2000*int1);
            }
}





