package PageObjectModel;

import Utilities.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage  {
    WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    //Header-------------------------------------------------------------
    private By loginAndRegistrationButton = By.cssSelector("a[href='/login']");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");


    //Actions------------------------------------------------------

    public MenuPage clickOnLoginORSignUpButton()
    {

        ElementActions.click(driver,loginAndRegistrationButton);
        return this;
    }
    public MenuPage clickOnDeleteAccountButton()
    {
        ElementActions.click(driver,deleteAccountButton);
        return this;
    }


}

