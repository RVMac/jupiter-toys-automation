package StepDefinitions;

import Pages.CartPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CartStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    CartPage cartPage = new CartPage(driver);

    // GIVEN

    // WHEN

    // THEN
    @Then("the price and subtotal value for each product is correct")
    public void thePriceAndSubtotalValueForEachProductIsCorrect(DataTable dataTable) {
        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> item : items) {
            String itemName = item.get("ItemName");
            int quantity = Integer.parseInt(item.get("Quantity"));
            String amountPerItem = item.get("AmountPerItem");
            String subtotalValue = item.get("SubtotalValue");

            cartPage.CheckPriceValue(itemName, amountPerItem);
            cartPage.CheckSubTotalValue(itemName, subtotalValue);
        }
    }

    @Then("the grand total value is equal to {string}")
    public void theGrandTotalValueIsEqualTo$(String grandTotal) {
        cartPage.verifyGrandTotalValue(grandTotal);
    }
}
