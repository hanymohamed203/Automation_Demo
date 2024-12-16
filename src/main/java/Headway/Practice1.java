package Headway;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys("حماقي", Keys.ENTER);
        WebElement WebElement = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md'][1]"));
        System.out.println(WebElement.getText());
    }

}
