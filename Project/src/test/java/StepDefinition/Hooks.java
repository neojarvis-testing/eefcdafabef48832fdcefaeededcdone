// package StepDefinition;

// import java.net.MalformedURLException;
// import org.openqa.selenium.WebDriver;
// import com.aventstack.extentreports.ExtentReports;
// import io.cucumber.java.After;
// import io.cucumber.java.Before;
// import Utils.*;

// public class Hooks {
//     private WebDriver driver;
//     private static ExtentReports reporter;
//     ExtentReports extent = new ExtentReports();

//     @Before
//     public void setUp() throws MalformedURLException {
//         Base base = new Base();
//         driver = base.openBrowser();
//         driver.manage().window().maximize();
//         extent = Reporter.generateExtentReport();
//     }

//     @After
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//         if (reporter != null) {
//             extent.flush();
//         }
//     }
// }
