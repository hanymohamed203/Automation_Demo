package PageObjectModel;

import Utilities.BrowserActions;
import Utilities.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpAndLoginPage {
    WebDriver driver;

    public SignUpAndLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
   private By nameOfSignUpField = By.name("name");
    private By emailOfSignUpField = By.cssSelector("input[data-qa=signup-email]");
    private By signUpButton = By.cssSelector("button[data-qa=signup-button]");
    private By SignupText=By.cssSelector("div.signup-form h2");

    String url ="https://automationexercise.com/login";

    public SignUpAndLoginPage Navigate()
    {

        BrowserActions.navigate(driver, url);
        return this;
    }



    //actions-------------------------------------------
    public String GetSignUpText()
    {
        return driver.findElement(SignupText).getText();
    }
    public void navigate()
    {

        BrowserActions.navigate(driver, url);
    }
    public SignUpAndLoginPage signUp(String username, String password) {
        driver.findElement(nameOfSignUpField).sendKeys(username);
        driver.findElement(emailOfSignUpField).sendKeys(password);
        return this;

    }
    public SignUpAndLoginPage clickOnSignUpButton(){
        ElementActions.click(driver,signUpButton);
        return this;
    }

    //validation---------------------------
    @Step("Assertion On SignUp and Login Page")
    public SignUpAndLoginPage assertOnLoginAndSignUpPage() {
        Assert.assertTrue(driver.findElement(emailOfSignUpField).isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com/login"));
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise - Signup"));
        return this;
    }

}
