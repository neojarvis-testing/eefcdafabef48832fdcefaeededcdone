package StepDefinition;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;

import Pages.Testcase2;
import Pages.Url;
import Utils.Base;
import Utils.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shopping {
    private static ExtentReports reporter;
    private Url url;
    private Testcase2 tesstcase2;
    private WebDriver driver;
    ExtentReports extent = new ExtentReports();
    ChromeOptions options = new ChromeOptions();
    Base base = new Base();

    public Shopping() {
    }

    @Before
    public void setUp() throws MalformedURLException {
        extent = Reporter.generateExtentReport();
    }
    
    @Given("^I am on ELC Homepage$")
    public void i_am_on_ELC_Homepage() throws Throwable {
        driver = base.openBrowser();
        driver.manage().window().maximize();
        url = new Url(driver);
        tesstcase2 = new Testcase2(driver);
        url.LaunchSite(driver);
    }

    @When("I hover the mouse over the \\\"([^\\\"]*)\\\" menu and click the \\\"([^\\\"]*)\\\" category")
    public void i_hover_the_mouse_over_the_menu_and_click_the_category(String arg1, String arg2) throws Throwable {
        tesstcase2.HovereToAge(arg1, arg2);
    }

    @When("^I scroll down until I locate the \"([^\"]*)\" option on the left side of the page$")
    public void i_scroll_down_until_I_locate_the_option_on_the_left_side_of_the_page(String arg1) throws Throwable {
        tesstcase2.scrolldown(arg1);

    }

    @When("^I click the value \"([^\"]*)\" from the price range options$")
    public void i_click_the_value_from_the_price_range_options(String arg1) throws Throwable {
        tesstcase2.priceRange(arg1);
    }

    @Then("^I verify the total number of results found based on the selected price range$")
    public void i_verify_the_total_number_of_results_found_based_on_the_selected_price_range() throws Throwable {
        tesstcase2.VerifyTheCount();
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
        extent.flush();
    }

}
