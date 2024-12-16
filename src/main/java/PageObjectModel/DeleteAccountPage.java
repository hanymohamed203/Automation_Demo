package PageObjectModel;

import Utilities.BrowserActions;
import Utilities.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccountPage  {

    WebDriver driver;
     //locators---------------------

    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By accountDeletedMessage = By.xpath("//h2[@data-qa='account-deleted']");

    //variables---------------
    String url ="https://automationexercise.com/delete_account";




    //actions-----------------------
    public DeleteAccountPage Navigate()
    {

        BrowserActions.navigate(driver, url);
        return this;
    }



    //validation--------------------------------------
    @Step("Assertion On Delete Account Page")
    public DeleteAccountPage assertOnDeleteAccountPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("delete_account"),"The expected Url contains 'delete_account' and the actual one "+driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(accountDeletedMessage).isDisplayed(),"ACCOUNT DELETED message is not displayed");
        Assert.assertTrue(ElementActions.getText(driver,accountDeletedMessage).contains("ACCOUNT DELETED!"), "The expected message isAccount Deleted! and the actual is " + ElementActions.getText(driver,accountDeletedMessage));
        return this;
    }







}
