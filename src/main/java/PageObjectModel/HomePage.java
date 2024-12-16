package PageObjectModel;

import Utilities.BrowserActions;
import Utilities.ElementActions;
import Utilities.JsonFileManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage  {
    WebDriver driver;
    private JsonFileManager jsonFileManager;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        jsonFileManager = new JsonFileManager("src/test/resources/JsonData.json");
    }

    private By TextOnHomePage=By.cssSelector("div.col-sm-6 h2");
    private By LogedInAsText=By.xpath("//a//i[@class='fa fa-user']");
    private By userName=By.xpath("//li/a/b");

    String url="https://automationexercise.com/";

    public HomePage navigate()
    {

        BrowserActions.navigate(driver, url);
        return this;
    }



    //validation-----------------------------
    @Step("Assertion On Home Page ")
    public HomePage assertionOnHomePage()
    {
        Assert.assertTrue(ElementActions.getText(driver,TextOnHomePage).contains("Full-Fledged practice website for Automation Engineers"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
        return this;
    }

    @Step("assertion on HomePage after registration")
    public HomePage assertionOnHomePageAfterRegistration(String username)
    {
        Assert.assertTrue(ElementActions.getText(driver,TextOnHomePage).contains("Full-Fledged practice website for Automation Engineers"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
        Assert.assertEquals(driver.findElement(userName).getText(),username);
        return this;
    }



}
