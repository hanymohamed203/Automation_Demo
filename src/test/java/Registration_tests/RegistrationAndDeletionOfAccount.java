package Registration_tests;

import PageObjectModel.*;
import Utilities.DriverFactory;
import Utilities.JsonFileManager;
import Utilities.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RegistrationAndDeletionOfAccount {



    boolean Newssletter = true;
    boolean specialOffer = true;


    private WebDriver driver;
    private JsonFileManager jsonFileManager;

    @BeforeClass
    @Description("Set up the browser")
    public void set_up() {
        PropertiesReader.loadProperties();
        driver= DriverFactory.initiateDriver(System.getProperty("browserName"), Boolean.parseBoolean(System.getProperty("MaximizeWindow")), Boolean.parseBoolean(System.getProperty("headless")));
        jsonFileManager = new JsonFileManager("src/test/resources/JsonData.json");
    }




    @Test(description = "This test case used for verifying that the user can create new account and delete it")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register and deletion of user")
    public void RegistrationAndDeletion() {
        new HomePage(driver).navigate().assertionOnHomePage();
        new MenuPage(driver).clickOnLoginORSignUpButton();
        new SignUpAndLoginPage(driver).assertOnLoginAndSignUpPage()
                .signUp(jsonFileManager.getTestData("UserName"), jsonFileManager.getTestData("UserMail"))
                .clickOnSignUpButton();
        new RegistrationPage(driver).assertOnEnterAccountInformationPage()
                .chooseGender(jsonFileManager.getTestData("AccountInformation.UserGender"))
                .enterPssword(jsonFileManager.getTestData("AccountInformation.Password"))
                .enterBirthday(jsonFileManager.getTestData("AccountInformation.Day"), jsonFileManager.getTestData("AccountInformation.Month"), jsonFileManager.getTestData("AccountInformation.Year")).checkBoxSelection(jsonFileManager.getTestData("AccountInformation.Newsletter"), jsonFileManager.getTestData("AccountInformation.SpecialOffer"))
                .enterFirstAndSecondNames(jsonFileManager.getTestData("AccountInformation.FirstName"), jsonFileManager.getTestData("AccountInformation.LastName"))
                .fillAddressesinformation(jsonFileManager.getTestData("AccountInformation.Company"), jsonFileManager.getTestData("AccountInformation.Address1"), jsonFileManager.getTestData("AccountInformation.Address2"), jsonFileManager.getTestData("AccountInformation.Country"), jsonFileManager.getTestData("AccountInformation.State"), jsonFileManager.getTestData("AccountInformation.City"), jsonFileManager.getTestData("AccountInformation.ZipCode"), jsonFileManager.getTestData("AccountInformation.MobileNumber"))
                .clickOnCreateAccountButton();
        new AccountCreatedPage(driver).assertOnCreatedAccountPage()
                .clickOnContinueButton();
        new HomePage(driver).assertionOnHomePageAfterRegistration(jsonFileManager.getTestData("UserName"));
        new MenuPage(driver).clickOnDeleteAccountButton();
        new DeleteAccountPage(driver).assertOnDeleteAccountPage();
    }

    @AfterClass
    @Description("Tear down method")
    public void DeleteUserAndTearDown() {
        driver.close();
    }




}

