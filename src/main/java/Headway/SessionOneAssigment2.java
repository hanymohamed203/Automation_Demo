package Headway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SessionOneAssigment2 {
    //new user Sign_up Locators
    By loginAndRegistrationButton = By.cssSelector("a[href='/login']");
    By nameOfSignUpField = By.name("name");
    By emailOfSignUpField = By.cssSelector("input[data-qa=signup-email]");
    By signUpButton = By.cssSelector("button[data-qa=signup-button]");
    By enterAccountInfoText = By.xpath("//div[@class='col-sm-4 col-sm-offset-1']/div/h2/b");


    //Enter Account Infromation Locators
    By maleTitle = By.id("id_gender1");
    By femaleTitle = By.id("id_gender2");
    By password = By.id("password");
    By daysDropdown = By.id("days");
    By monthsDropdown = By.id("months");
    By yearsDropdown = By.id("years");
    By newSletterCheckbox = By.id("newsletter");
    By specialOfferFromPartnerCheckbox = By.id("optin");
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By companyNameField = By.id("company");
    By address1Field = By.id("address1");
    By address2Field = By.id("address2");
    By countryDropdown = By.id("country");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipcodeField = By.id("zipcode");
    By mobileNumberField = By.id("mobile_number");
    By createAccountButton = By.cssSelector("button[data-qa=create-account]");
    By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");


    //delete Account Locators
    By continueButton = By.cssSelector("a[data-qa=continue-button]");
    By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    By accountDeletedMessage = By.xpath("//h2[@data-qa='account-deleted']");


    WebDriver driver;

    @BeforeClass
    public void Prerequisites() {
        setUp();
    }

    @Test(description = "This test case used for verifying that the user can create new account and delete it")
    public void RegistrationAndDeletion() {
        //new user Sign_up
        clickOnSignUpAndLoginButton();
        assertOnLoginAndSignUpPage();
        signUp("hany", "Hanyyyyy@gmail.com");
        assertOnEnterAccountInformationPage();
        chooseGender("Male");
        enterPssword("123456789");
        enterBirthday("20", "1", "2001");
        enterFirstAndSecondNames("Hany", "Mohamed");
        checkBoxSelection(true,false);
        fillAddressesinformation("Gizasystems", "zaton", "ghrbya", "India", "012", "cairo", "123","01127029519");
        clickOnCreateAccountButton();
        assertOnCreatedAccountPage();
        clickOnContinueButton();
        clickOnDeleteButton();
        assertOnDeleteAccountPage();


    }

    @AfterClass
    public void CloseBrowser() {
        teardown();
    }


    public void signUp(String username, String password) {
        driver.findElement(loginAndRegistrationButton).click();
        driver.findElement(nameOfSignUpField).sendKeys(username);
        driver.findElement(emailOfSignUpField).sendKeys(password);
        driver.findElement(signUpButton).click();
    }

    public void assertOnEnterAccountInformationPage() {
        Assert.assertTrue(driver.findElement(enterAccountInfoText).getText().contains("ENTER ACCOUNT INFORMATION"), "The expected message is ENTER ACCOUNT INFORMATION and the actual is " + driver.findElement(enterAccountInfoText).getText());
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),"The expected Url contains 'signup' and the actual one "+driver.getCurrentUrl());
    }

    public void assertOnLoginAndSignUpPage() {
        Assert.assertTrue(driver.findElement(emailOfSignUpField).isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com/login"));
    }

    public void clickOnSignUpAndLoginButton() {
        driver.findElement(loginAndRegistrationButton).click();
    }

    public void enterBirthday(String DayOfBirth, String MonthOfbirth, String YearOfBirth) {
        new Select(driver.findElement(daysDropdown)).selectByValue(DayOfBirth);
        new Select(driver.findElement(monthsDropdown)).selectByValue(MonthOfbirth);
        new Select(driver.findElement(yearsDropdown)).selectByValue(YearOfBirth);
    }

    public void enterFirstAndSecondNames(String FirstName, String LastName) {
        driver.findElement(firstNameField).sendKeys(FirstName);
        driver.findElement(lastNameField).sendKeys(LastName);
    }

    public void chooseGender(String title) {
        if (title.equalsIgnoreCase("Male")) {
            driver.findElement(maleTitle).click();
        } else {
            driver.findElement(femaleTitle).click();
        }

    }

    public void checkBoxSelection(boolean Newsletter, boolean Specialoffer) {
        if (Newsletter)
            driver.findElement(newSletterCheckbox).click();
        if (Specialoffer)
            driver.findElement(specialOfferFromPartnerCheckbox).click();
    }

    public void enterPssword(String Passwrod) {
        driver.findElement(password).sendKeys(Passwrod);
    }

    public void fillAddressesinformation(String CompanyName, String Address1, String Address2, String Country, String State, String City, String Zipcode,String MobileNumber) {
        driver.findElement(companyNameField).sendKeys(CompanyName);
        driver.findElement(address1Field).sendKeys(Address1);
        driver.findElement(address2Field).sendKeys(Address2);
        new Select(driver.findElement(countryDropdown)).selectByValue(Country);
        driver.findElement(stateField).sendKeys(State);
        driver.findElement(cityField).sendKeys(City);
        driver.findElement(zipcodeField).sendKeys(Zipcode);
        driver.findElement(mobileNumberField).sendKeys(MobileNumber);
    }



    public void clickOnCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }

    public void assertOnCreatedAccountPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account_created"),"The expected Url contains 'account_created' and it is the actual one "+driver.getCurrentUrl());
        Assert.assertEquals(driver.findElement(accountCreatedMessage).isDisplayed(), true,"ACCOUNT CREATED message is not displayed");
        Assert.assertTrue(driver.findElement(accountCreatedMessage).getText().contains("ACCOUNT CREATED!"), "The expected message is Account Created! and the actual is " + driver.findElement(accountCreatedMessage).getText());
    }

    public void clickOnContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickOnDeleteButton() {
        driver.findElement(deleteAccountButton).click();
    }

    public void assertOnDeleteAccountPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("delete_account"),"The expected Url contains 'delete_account' and the actual one "+driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(accountDeletedMessage).isDisplayed(),"ACCOUNT DELETED message is not displayed");
        Assert.assertTrue(driver.findElement(accountDeletedMessage).getText().contains("ACCOUNT DELETED!"), "The expected message isAccount Deleted! and the actual is " + driver.findElement(accountDeletedMessage).getText());
    }

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void teardown() {
        driver.close();
    }

}



