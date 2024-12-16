package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    static WebDriver driver;

    @Step("Navigate to URL {url}")
    public static void navigate(WebDriver driver, String url ){
        System.out.println("navigating to url: "+ url);
        driver.get(url);
    }
    public static void Refresh()
    {
        driver.navigate().refresh();
        System.out.println("the page is refreshed successfully ");
    }
}
