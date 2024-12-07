package Pages;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import StepDefinition.Homepage;
import org.apache.log4j.Logger;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Utils.*;
import UiStore.*;

public class Testcase3 {
    private WebDriver driver;
    private WebDriverHelper driverHelper;
    private ExtentTest test;
    static Logger logger = Logger.getLogger(LoggerHandler.class);


    public Testcase3(WebDriver driver) {
        this.driver = driver;
        driverHelper = new WebDriverHelper(driver);
        LoggerHandler.initLog4j();
        test = Reporter.generateExtentReport().createTest("Offers", "Execution for Shopping Function");
    }
       
    public void ClickMenu(String arg1, String arg2) throws Throwable {
        try {
            driverHelper.clickElement(OffersUI.Offers);
             test.log(Status.PASS, "Clicked The offers menu");
             logger.info(arg2);

        } catch (Exception e) {
            e.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Selecting Offer Error");
            test.fail("Failed to Click the offer ", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
       
        }
    }
    
   
    public void scrolldown(String arg1) throws Throwable {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 800);");
                test.log(Status.PASS, "Scroll down to the Cost");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Scroll down to the Cost Error");
                test.fail("Failed to Scroll down", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
    }
        public void Click_Showmore(String arg1) throws Throwable {
            try {
                driverHelper.clickElement(OffersUI.Showmore);
                 test.log(Status.PASS, "Selected the Brands");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Select Brand Error");
                test.fail("Failed to Selecte the Brand", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
        }
        public void Select_Brand(String arg1) throws Throwable {
            try {
                driverHelper.clickElement(OffersUI.Brands);
                 test.log(Status.PASS, "Selected the Brands");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Select Brand Error");
                test.fail("Failed to Selecte the Brand", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
        }
    
    public void Check_Avaliable()throws Throwable {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                String c1Text = driver.findElement(OffersUI.ProductName).getText();
                test.log(Status.PASS, "Assert the value");
                Screenshot.getScreenShot(driver, "Offers the value sucessfully");


        } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Assert the value Error");
                test.fail("Failed to Assert the value", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
        test.log(Status.PASS, "Browser closed");
        }   
    
}



