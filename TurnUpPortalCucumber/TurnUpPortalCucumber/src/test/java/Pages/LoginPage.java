package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    public void LoginActions(WebDriver driver) throws InterruptedException {
        //private readonly By Object userNameTextboxLocator = By.id("UserName");
        //WebElement usernameTextbox;

        //private readonly By passwordTextboxLocator = By.Id("Password");
        //WebElement passwordTextbox;

        //private readonly By loginButtonLocator = By.XPath("//*[@id=\"loginForm\"]/form/div[3]/input[1]");
        //WebElement loginButton;


        //WebDriver driver = new ChromeDriver();

        //Lunch TurnUp portal
        driver.navigate().to("http://horse.industryconnect.io/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        //Wait.WaitToBeClickable(driver, "Id", "UserName", 4);

        try
        {
            WebElement usernameTextbox = driver.findElement(By.id("UserName"));
            usernameTextbox.sendKeys("hari");
        }
        catch (Exception ex)
        {
            Assert.fail("Username textbox not located");
        }

        try
        {
            WebElement passwordTextbox = driver.findElement(By.id("Password"));
            passwordTextbox.sendKeys("123123");
        }
        catch (Exception ex)
        {
            Assert.fail("Password textbox not located");
        }

        try
        {
            //Identify login button and click on it
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));
            loginButton.click();
            Thread.sleep(8000);
        }
        catch (Exception ex)
        {
            Assert.fail("Login button not located");
        }
    }
}
