package StepDefinitions;

import Pages.ContactPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class ContactStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    ContactPage contactPage = new ContactPage(driver);

    // GIVEN

    // WHEN
    @When("I submit the feedback")
    public void i_submit_the_feedback(){
        contactPage.clickSubmit();
    }

    @When("I populate the mandatory fields")
    public void i_populate_the_mandatory_fields(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps();

        for (Map<String, String> credential : credentials) {
            String Forename = credential.get("Forename");
            String Email = credential.get("Email");
            String Message = credential.get("Message");

            contactPage.filloutRequiredFields(Forename, Email, Message);
        }
    }

    // THEN
    @Then("I can see header page error messages")
    public void i_can_see_header_page_error_messages(){
        contactPage.verifyHeaderPageErrorMessage(true);
    }

    @Then("I can see error messages from required fields")
    public void i_can_see_error_messages_from_required_fields(){
        contactPage.verifyRequiredFieldsErrorMessages(true  );
    }

    @Then("header page error message will be removed")
    public void headerPageErrorMessageWillBeRemoved() {
        contactPage.verifyHeaderPageErrorMessage(false  );
    }

    @Then("error messages from required fields will be removed")
    public void errorMessagesFromRequiredFieldsWillBeRemoved() {
        contactPage.verifyRequiredFieldsErrorMessages(false);
    }

    @Then("the feedback is submitted successfully")
    public void theFeedbackIsSubmittedSuccessfully() {
        contactPage.verifySuccessfulFeedbackSubmission();
    }
}
