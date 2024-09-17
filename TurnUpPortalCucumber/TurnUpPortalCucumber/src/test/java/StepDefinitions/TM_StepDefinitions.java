package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import Utilities.CommonDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TM_StepDefinitions extends CommonDriver {

    LoginPage loginPageObj = new LoginPage();
    HomePage homePageObj = new HomePage();
    TMPage tMPageObj = new TMPage();

    @Given("I logged into TurnUp portal successfully")
    public void iLoggedIntoTurnUpPortalSuccessfully() throws InterruptedException {

            //open Chrome Browser
            driver = new ChromeDriver();

            //Login page object initialization and definition

            loginPageObj.LoginActions(driver);

    }

    @When("I navigate to Time and Material page")
    public void iNavigateToTimeAndMaterialPage() {

        homePageObj.NavigateTOTMPage(driver);
    }

    @When("I create a time record {String}, {String}, {String} and {String}")
    public void iCreateATimeRecordTypeCodeCodeDescriptionAndPrice(String typeCode, String code, String description, String price) throws InterruptedException {

        tMPageObj.CreateTimeRecord(driver, typeCode, code, description, price);
    }

    @Then("the record should have the created {String}, {String}, {String} and {String}")
    public void theRecordShouldHaveTheCreatedTypeCodeCodeDescriptionAndPrice(String typeCode, String code, String description, String price) {

        String editedTypeCode = tMPageObj.GetEditedTypeCode(driver);
        String editedCode = tMPageObj.GetEditedCode(driver);
        String editedDescription = tMPageObj.GetEditedDescription(driver);
        String editedPrice = tMPageObj.GetEditedPrice(driver);

        Assert.assertEquals(editedTypeCode, typeCode, "Type code record has not been updated");
        Assert.assertEquals(editedCode, code, "Time record has not been updated");
        Assert.assertEquals(editedDescription, description, "Description record has not been updated");
        Assert.assertEquals(editedPrice, "$" + price + ".00", "Price record has not been updated");
    }

    @When("I update the {String}, {String}, {String} and {String} on an existing Time record")
    public void iUpdateTheTypeCodeCodeDescriptionAndPriceOnAnExistingTimeRecord(String typeCode, String code, String description, String price) throws InterruptedException {

        tMPageObj.EditTimeRocord(driver, typeCode, code, description, price);
    }

    @Then("the record should have the updated {String}, {String}, {String} and {String}")
    public void theRecordShouldHaveTheUpdatedTypeCodeCodeDescriptionAndPrice(String typeCode, String code, String description, String price) {

        String editedTypeCode = tMPageObj.GetEditedTypeCode(driver);
        String editedCode = tMPageObj.GetEditedCode(driver);
        String editedDescription = tMPageObj.GetEditedDescription(driver);
        String editedPrice = tMPageObj.GetEditedPrice(driver);

        Assert.assertEquals(editedTypeCode, typeCode, "Type code record has not been updated");
        Assert.assertEquals(editedCode, code, "Time record has not been updated");
        Assert.assertEquals(editedDescription, description, "Description record has not been updated");
        Assert.assertEquals(editedPrice, "$" + price + ".00", "Price record has not been updated");
    }

    @When("I delete an existing record")
    public void iDeleteAnExistingRecord() throws InterruptedException {

        tMPageObj.DeleteTimeRecord(driver);
    }

    @Then("the record should not be similat to {String}")
    public void theRecordShouldNotBeSimilatToStoredCode(String storedCode) throws InterruptedException {

        String deletedCode = tMPageObj.GetDeletedCode(driver);

        Assert.assertNotEquals(deletedCode, storedCode, "Record has not been delete");
    }
}
