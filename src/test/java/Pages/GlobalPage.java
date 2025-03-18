package Pages;

import Utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GlobalPage {
    private final WebDriver driver;
    private final CommonFunctions common;

    public GlobalPage(WebDriver driver) {
        this.driver = driver;
        this.common = new CommonFunctions(driver);
    }

    //region Locators
    By NavHome = By.id("nav-home");
    By NavShop = By.id("nav-shop");
    By NavContact = By.id("nav-contact");

    //region Methods
    public void clickHomeNav(){
        common.click(NavHome);
    }

    public void clickShopNav(){
        common.click(NavShop);
    }

    public void clickContactNav(){
        common.click(NavContact);
    }
}
