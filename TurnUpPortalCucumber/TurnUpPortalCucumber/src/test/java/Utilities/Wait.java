package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    public static void WaitToBeClickable(WebDriver driver, String locatorType, String locatorValue, int seconds)
    {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        if(locatorType == "XPath")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        }

        if (locatorType == "Id")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
        }

        if (locatorType == "CssSelector")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
        }

        if (locatorType == "Name")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
        }
    }
    
}
