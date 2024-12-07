package UiStore;

import org.openqa.selenium.By;

public class HomepageUI {
    

    public static By SearchBar = By.xpath("//*[@id=\"autocomplete-0-input\"]");
    public static By SelectList = By.xpath("/html/body/main/div[4]/div[4]/div[2]/div[1]/div/div[4]/div/a/div[2]");
    public static By ProductName = By.xpath("//h1[contains(text(),'Peppa Pig: Peppa\u2019s Adventures - Peppa\u2019s Family Mot')]");
    public static By AllowButton = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
   
}
