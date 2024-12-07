package StepDefinition;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;

import Pages.Testcase1;
import Pages.Url;
import Utils.Base;
import Utils.LoggerHandler;
import Utils.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import  org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Homepage{
    ExtentReports extent = new ExtentReports();
    private Url url;
    private Testcase1 testcase1;
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    Base base = new Base();
    static Logger logger = Logger.getLogger(Homepage.class);


    public Homepage() { 
    }

    @Before
    public void setUp() throws MalformedURLException {
       extent = Reporter.generateExtentReport();
       LoggerHandler.initLog4j();
    }
    
    @Given("^I am on ELC Website$")
    public void i_am_on_ELC_Website() throws Throwable {
        driver = base.openBrowser();
        driver.manage().window().maximize();
        url = new Url(driver);
        testcase1 = new Testcase1(driver);
        url.LaunchSite(driver);
        logger.info("This is info message");
        logger.warn("This is warining message");
        logger.debug("This is debug message");
        logger.error( "This is error message");
        logger.fatal("This is fatal message");
    }

    @When("^I input the text \"([^\"]*)\" into the search box$")
    public void i_input_the_text_into_the_search_box(String arg1) throws Throwable {
        testcase1.ClickSearch("Peppa pig");
    }

    @When("^I click on the first option from the auto-populated list$")
    public void i_click_on_the_first_option_from_the_auto_populated_list() throws Throwable {
        testcase1.SelectFromList();
    }

    @Then("^I confirm that the search results page contains the label \"([^\"]*)\"$")
    public void i_confirm_that_the_search_results_page_contains_the_label(String arg1) throws Throwable {
        testcase1.ClickSearch("Peppa pig");
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
        extent.flush();
    }

}
