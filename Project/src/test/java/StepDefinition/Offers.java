package StepDefinition;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Pages.*;
import Utils.*;
import UiStore.*;

public class Offers{
    private static ExtentReports reporter;
    private Url url;
    private Testcase3 testcase3;
    private WebDriver driver;
    ExtentReports extent = new ExtentReports();
    ChromeOptions options = new ChromeOptions();
    Base base = new Base();


    public Offers() {
    }

    public Offers(WebDriver driver) {
        this.driver = driver;
        reporter = Reporter.generateExtentReport();
    }
   @Before
    public void beforeMethod() throws MalformedURLException {
    extent = Reporter.generateExtentReport();
}

    @Given("^I am on ELC Application for click$")
    public void i_am_on_ELC_Homepage() throws Throwable {
        driver = base.openBrowser();
        driver.manage().window().maximize();
        url = new Url(driver);
        testcase3 = new Testcase3(driver);
        url.LaunchSite(driver);
    }
        

        @When("^I click on the \"([^\"]*)\" menu$")
        public void i_click_on_the_menu(String arg1) throws Throwable {
            testcase3.ClickMenu(arg1, arg1);
        }

        @When("^I scroll down until I reach the \"([^\"]*)\" filter$")
        public void i_scroll_down_until_I_reach_the_filter(String arg1) throws Throwable {
            testcase3.scrolldown(arg1);
        }

        @When("^I click on the \"([^\"]*)\" link$")
        public void i_click_on_the_link(String arg1) throws Throwable {
            testcase3.Click_Showmore(arg1);
        }

        @When("^I click the checkbox of \"([^\"]*)\"$")
        public void i_click_the_checkbox_of(String arg1) throws Throwable {
            // testcase3.Select_Brand(arg1);
        }

        @Then("^I verify whether the name of the chosen brand is available on the page$")
        
        public void i_verify_whether_the_name_of_the_chosen_brand_is_available_on_the_page() throws Throwable {
            testcase3.Check_Avaliable();
        }
@After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
       extent.flush();
    }

}
