package StepDefinitions;

import Pages.GlobalPage;
import Pages.HomePage;
import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomeStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    GlobalPage globalPage = new GlobalPage(driver);

    // GIVEN
    @Given("I am in Home page")
    public void i_am_in_home_page() {
        homePage.NavigateToHome();
    }

    // WHEN
    @When("I navigate to Contact page")
    public void i_navigate_to_contact_page(){
        globalPage.clickContactNav();
    }

    @When("I navigate to Shop page")
    public void iNavigateToShopPage() {
        globalPage.clickShopNav();
    }

    // THEN
}
