

package Pages;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Utils.*;
import UiStore.*;

public class Url {
    Base base = new Base();
    ChromeOptions options = new ChromeOptions();
    private WebDriverHelper driverHelper;

    public Url(WebDriver driver) {
        driverHelper = new WebDriverHelper(driver);
    }
    
    public void LaunchSite(WebDriver driver) {
        try {
            driver.get("https://www.elc.co.uk");
            options.addArguments("--remote-allow-origins=*");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(HomepageUI.AllowButton));
            driverHelper.clickElement(driver, acceptCookiesButton);
            Screenshot.getScreenShot(driver, "Site launched sucessfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}