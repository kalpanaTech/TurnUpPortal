package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage{
        public void NavigateTOTMPage(WebDriver driver)
        {
            // Navigate to time and Material Page
            WebElement administrationTab = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a/span"));
            administrationTab.click();

            //Wait.WaitToBeClickable(driver, "XPath", "/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a", 15);

            WebElement timeAndMaterialOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
            timeAndMaterialOption.click();
        }

        public void NavigateToEMPPage(WebDriver driver)
        {
            // Navigate to time and Material Page
            WebElement administrationTab = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a/span"));
            administrationTab.click();

           //Wait.WaitToBeClickable(driver, "XPath", "/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a", 10);

            WebElement employeeOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a"));
            employeeOption.click();
        }
    }

