package UiStore;

import org.openqa.selenium.By;

public class ShoppingUI {
    

    public static By Shop_By_Age = By.xpath("//a[contains(text(),'Shop by age')]");
    public static By SelectAge = By.xpath("//a[contains(text(),'0-3 months')]");
    public static By SelectCost = By.xpath("//*[@id=\"product-facet\"]/div[14]/div[8]/div/div[2]/div/div/ul/li[2]/div/label/span/span[1]");
    public static By C1 = By.xpath("//*[@id=\"product-facet\"]/div[14]/div[8]/div/div[2]/div/div/ul/li[2]/div/label/span/span[3]");
    public static By C2 = By.xpath("//body/main[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]");
    public static By AllowButton = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
   
}