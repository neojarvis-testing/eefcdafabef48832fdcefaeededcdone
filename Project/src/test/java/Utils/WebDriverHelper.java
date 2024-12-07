package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverHelper extends Base {
    private WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) throws Exception {
        try {
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
    }

    public void clickElement(WebDriver driverObj, WebElement element) throws Exception {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
    }

    public void clickElement(By locator) throws Exception {
        try {
            WebElement element = driver.findElement(locator);
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
    }

    public WebElement fillForm(By locator, String text) throws Exception {
        try {
            WebElement element = driver.findElement(locator);
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
        return null;
    }

    public void hoverOneElement(By locator) throws Exception {
        try {
            WebElement element = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
    }

    public void hoverTwoElements(By firstLocator, By secondLocator) throws Exception {
        try {
            WebElement firstElement = driver.findElement(firstLocator);
            WebElement secondElement = driver.findElement(secondLocator);
            
            Actions actions = new Actions(driver);
            actions.moveToElement(firstElement).moveToElement(secondElement).perform();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
    }
    
}
