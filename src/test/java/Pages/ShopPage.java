package Pages;

import Utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {
    private final WebDriver driver;
    private final CommonFunctions common;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        this.common = new CommonFunctions(driver);
    }

    // LOCATORS

    // METHODS
    public void BuyItem(String itemName, int count) {
        for (int i = 1; i <= count; i++){
            common.click(By.xpath("//h4[.='"+itemName+"']//following-sibling::p//a"));
        }
    }
}
