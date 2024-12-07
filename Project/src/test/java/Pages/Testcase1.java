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
import Utils.*;
import UiStore.*;

public class Testcase1 {
    Base base = new Base();
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    private WebDriverHelper driverHelper;
    Reporter reporter = new Reporter();

    public Testcase1(WebDriver driver) {
        this.driver = driver;
        driverHelper = new WebDriverHelper(driver);
    }
    
    ExtentTest test = Reporter.generateExtentReport().createTest("Homepage", "Execution for HomePage Function");
   
    public void ClickSearch(String search_text) throws Throwable {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driverHelper.fillForm(HomepageUI.SearchBar, search_text);
            test.log(Status.PASS, "Send key sucessfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Send key Error");
            test.fail("Failed to Send keys ", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
        }
    }
    
   
    public void SelectFromList() {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(HomepageUI.SelectList));
            element.click();
            test.log(Status.PASS, "Selected from the list");
        } catch (Exception ex) {
            ex.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Selecting values Error");
            test.fail("Failed to Selecte thev value from the list", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
        }
    }
    
  
    public void CompareValue(String Expected_Label) throws Throwable {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Peppa Pig: Peppa\u2019s Adventures - Peppa\u2019s Family Mot')]")));
            String labelText = element.getText();
            if (labelText.toLowerCase().contains(Expected_Label.toLowerCase())) {
                return;
            } else {
                Assert.assertTrue("Expected label text to contain '" + Expected_Label + "', but it was '" + labelText + "'", labelText.contains(Expected_Label));
            }
            
            Screenshot.getScreenShot(driver, "Assert the value sucessfully");
            test.log(Status.PASS, "Assert the value");
            Screenshot.getScreenShot(driver, "Assert the value sucessfully");
            throw new PendingException();
        } catch (Exception ex) {
            ex.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Assert the value Error");
            test.fail("Failed to Assert the value", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
        }


    }
    
}



