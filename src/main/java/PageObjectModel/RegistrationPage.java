package PageObjectModel;

import Utilities.BrowserActions;
import Utilities.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Enter Account Infromation Locators
    By enterAccountInfoText = By.xpath("(//h2[@class='title text-center'])[1]");
    private By maleTitle = By.id("id_gender1");
    private By femaleTitle = By.id("id_gender2");
    private By password = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By specialOfferFromPartnerCheckbox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyNameField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("button[data-qa=create-account]");
    private By newSletterCheckbox = By.id("newsletter");

    String url ="https://automationexercise.com/signup";


    //actions-------------------------------

    public RegistrationPage navigate()
    {

        BrowserActions.navigate(driver, url);
        return this;
    }
    public RegistrationPage chooseGender(String title) {
        if (title.equalsIgnoreCase("Male")) {
            driver.findElement(maleTitle).click();
        } else {
            driver.findElement(femaleTitle).click();
        }
        return this;

    }
    public RegistrationPage checkBoxSelection(String Newsletter, String Specialoffer) {
        if (Newsletter.equalsIgnoreCase("true"))
            driver.findElement(newSletterCheckbox).click();
        if (Specialoffer.equalsIgnoreCase("true"))
            driver.findElement(specialOfferFromPartnerCheckbox).click();

        return this;
    }
    public RegistrationPage enterPssword(String Passwrod) {
        driver.findElement(password).sendKeys(Passwrod);
        return this;
    }
    public RegistrationPage fillAddressesinformation(String CompanyName, String Address1, String Address2, String Country, String State, String City, String Zipcode,String MobileNumber) {
        driver.findElement(companyNameField).sendKeys(CompanyName);
        driver.findElement(address1Field).sendKeys(Address1);
        driver.findElement(address2Field).sendKeys(Address2);
        new Select(driver.findElement(countryDropdown)).selectByValue(Country);
        driver.findElement(stateField).sendKeys(State);
        driver.findElement(cityField).sendKeys(City);
        driver.findElement(zipcodeField).sendKeys(Zipcode);
        driver.findElement(mobileNumberField).sendKeys(MobileNumber);
        return this;
    }

    public RegistrationPage enterFirstAndSecondNames(String FirstName, String LastName) {
        driver.findElement(firstNameField).sendKeys(FirstName);
        driver.findElement(lastNameField).sendKeys(LastName);
        return this;
    }
    public RegistrationPage enterBirthday(String DayOfBirth, String MonthOfbirth, String YearOfBirth) {
        new Select(driver.findElement(daysDropdown)).selectByValue(DayOfBirth);
        new Select(driver.findElement(monthsDropdown)).selectByValue(MonthOfbirth);
        new Select(driver.findElement(yearsDropdown)).selectByValue(YearOfBirth);
        return this;
    }
    public RegistrationPage clickOnCreateAccountButton() {
        ElementActions.click(driver,createAccountButton);
        return this;
    }








    //validationss
    public RegistrationPage assertOnEnterAccountInformationPage() {
        Assert.assertTrue(ElementActions.getText(driver,enterAccountInfoText).contains("ENTER ACCOUNT INFORMATION"), "The expected message is ENTER ACCOUNT INFORMATION and the actual is " + ElementActions.getText(driver,enterAccountInfoText));
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"), "The expected Url contains 'signup' and the actual one " + driver.getCurrentUrl());
        return this;
    }







}
