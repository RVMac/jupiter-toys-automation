package Pages;

import Utilities.CommonFunctions;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final CommonFunctions common;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.common = new CommonFunctions(driver);
    }

    public void NavigateToHome() {
        driver.navigate().to("https://jupiter.cloud.planittesting.com/#/home");
    }
}
