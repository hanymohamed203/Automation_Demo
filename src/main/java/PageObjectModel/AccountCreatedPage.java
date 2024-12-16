package PageObjectModel;

import Utilities.BrowserActions;
import Utilities.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreatedPage  {
    //locators
    WebDriver driver;
    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.cssSelector("a[data-qa=continue-button]");

    String AccountCreatedPageUrl="https://automationexercise.com/account_created";

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountCreatedPage Navigate()
    {

        BrowserActions.navigate(driver,AccountCreatedPageUrl);
        return this;
    }


    //actions---------------------

    public AccountCreatedPage clickOnContinueButton()
    {
        ElementActions.click(driver,continueButton);
        return this;
    }

    //assertion---------------------------
    @Step("Assertion On Created Account Page")
    public AccountCreatedPage assertOnCreatedAccountPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account_created"),"The expected Url contains 'account_created' and it is the actual one "+driver.getCurrentUrl());
        Assert.assertTrue(ElementActions.getText(driver,accountCreatedMessage).contains("ACCOUNT CREATED!"), "The expected message is Account Created! and the actual is " + ElementActions.getText(driver,accountCreatedMessage));
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise - Account Created"),"the Expected title is Automation Exercise - Account Created and the actual is "+driver.getTitle());
        return this;
    }
}
