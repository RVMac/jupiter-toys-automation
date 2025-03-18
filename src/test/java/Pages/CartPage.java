package Pages;

import Utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    private final WebDriver driver;
    private final CommonFunctions common;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.common = new CommonFunctions(driver);
    }

    // Locators
    By grandTotalElement = By.xpath("//tfoot//strong");

    // Methods
    public void CheckPriceValue(String itemName, String amountPerItem) {

        By priceElement = By.xpath("//td[.=' "+itemName+"']//following-sibling::td[1]");
        String actualPriceValue = common.getText(priceElement);
        Assert.assertEquals(amountPerItem, actualPriceValue, "Price values are not equal. Expected: " + amountPerItem +"; Actual: "+ actualPriceValue);
    }

    public void CheckSubTotalValue(String itemName, String subtotalValue) {
        By subTotalElement = By.xpath("//td[.=' "+itemName+"']//following-sibling::td[3]");
        String actualSubtotalValue = common.getText(subTotalElement);
        Assert.assertEquals(subtotalValue, actualSubtotalValue, "Price values are not equal. Expected: " + subtotalValue +"; Actual: "+ actualSubtotalValue);
    }

    public void verifyGrandTotalValue(String grandTotal) {
        String actualGrandTotalText = common.getText(grandTotalElement);
        actualGrandTotalText = "$" + actualGrandTotalText.substring(7);
        Assert.assertEquals(grandTotal, actualGrandTotalText, "Price values are not equal. Expected: " + grandTotal +"; Actual: "+ actualGrandTotalText);
    }
}