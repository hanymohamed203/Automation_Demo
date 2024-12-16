package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
     static WebDriver driver;

    public static WebDriver initiateDriver(String browserName,boolean maximize) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            System.out.println("intializing Chrome Browser on OS : "+System.getProperty("os.name")+"and the version is "+System.getProperty("os.version"));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("intializing firefox Browser on OS : "+System.getProperty("os.name")+"and the version is "+System.getProperty("os.version"));
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("intializing Edge Browser on OS : "+System.getProperty("os.name")+"and the version is "+System.getProperty("os.version"));
            driver = new EdgeDriver();

        }

        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("window is maximized , and the window size is " + driver.manage().window().getSize());
        }

        return driver;
    }
}
