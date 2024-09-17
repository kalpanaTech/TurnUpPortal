package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TMPage {

    public void CreateTimeRecord(WebDriver driver, String typeCode, String code, String description, String price) throws InterruptedException {

        try
        {
            // click on Create New Button
            WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
            createNewButton.click();
        }
        catch (Exception ex)
        {
            Assert.fail("Create New button not found");
        }

        // Select Time from dropdown
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
        typeCodeDropdown.click();
        Thread.sleep(2000);

        if (typeCode == "T")
        {
            WebElement timeOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
            timeOption.click();
            Thread.sleep(2000);
        }

        else if (typeCode == "M")
        {
            WebElement materialOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[1]"));
            materialOption.click();
            Thread.sleep(2000);
        }

        // Type code into Code getText()box
        WebElement codeTextBox = driver.findElement(By.id("Code"));
        codeTextBox.sendKeys(code);

        // Type Description into Description getText()box
        WebElement descriptionTextBox = driver.findElement(By.id("Description"));
        descriptionTextBox.sendKeys(description);

        // Type price into Price getText()box
        WebElement priceTagOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTagOverlap.click();

        WebElement priceTextBox = driver.findElement(By.id("Price"));
        priceTextBox.sendKeys(price);

        //Wait.WaitToBeclickable(driver, "Id", "SaveButton", 3);

        // click on Save button
        WebElement saveButton = driver.findElement(By.xpath("SaveButton"));
        saveButton.click();
        Thread.sleep(1000);

        // Check if Time record has been created successfully
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        Thread.sleep(6000);
        //Wait.WaitToBeclickable(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 10);
        goToLastPageButton.click();
        Thread.sleep(7000);
    }

    public void EditTimeRocord(WebDriver driver, String typeCode, String code, String description, String price) throws InterruptedException {
        WebElement goToLastPageButton;

        Thread.sleep(4000);

        try
        {
            // Edit the last created record
            goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
            Thread.sleep(6000);
            goToLastPageButton.click();

        }
        catch (Exception ex)
        {
            Assert.fail("Go to last page button not found");
        }

        Thread.sleep(4000);

        //click on the Edit button
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        Thread.sleep(8000);
        editButton.click();

        //Change the TypeCode
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
        typeCodeDropdown.click();

        if (typeCode == "T")
        {
            WebElement timeOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
            timeOption.click();
            Thread.sleep(2000);
        }

        else if (typeCode == "M")
        {
            WebElement materialOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[1]"));
            materialOption.click();
            Thread.sleep(2000);
        }
        else
        {
            WebElement selectedOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_option_selected\"]"));
            selectedOption.click();
            Thread.sleep(2000);
        }

        // Change the Code
        WebElement codeTextBox = driver.findElement(By.id("Code"));
        codeTextBox.clear();
        codeTextBox.sendKeys(code);
        Thread.sleep(2000);


        // Chage the Description
        WebElement descriptionTextBox = driver.findElement(By.id("Description"));
        descriptionTextBox.clear();
        descriptionTextBox.sendKeys(description);

        // Change the Price per unit
        WebElement priceTagOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTagOverlap.click();


        WebElement priceTextBox = driver.findElement(By.id("Price"));
        priceTextBox.clear();
        Thread.sleep(2000);

        priceTagOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTagOverlap.click();
        priceTextBox = driver.findElement(By.id("Price"));
        Thread.sleep(2000);
        priceTextBox.click();
        priceTextBox.sendKeys(price);

        // Save the changes
        // click on Save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        Thread.sleep(4000);

        // Check if Time record has been created successfully
        goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        Thread.sleep(6000);
        //Wait.WaitToBeclickable(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 10);
        goToLastPageButton.click();
        Thread.sleep(10000);

    }

    public String GetEditedTypeCode(WebDriver driver)
    {
        // Wait.WaitToBeVisible(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[2]", 10);
        WebElement editedTypeCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[2]"));
        return editedTypeCode.getText();
    }
    public String GetEditedCode(WebDriver driver)
    {
        WebElement editedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return editedCode.getText();
    }

    public String GetEditedDescription(WebDriver driver)
    {
        WebElement editedDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return editedDescription.getText();
    }
    public String GetEditedPrice(WebDriver driver)
    {
        WebElement editedPrice = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        return editedPrice.getText();
    }

    public void DeleteTimeRecord(WebDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        try
        {
            // Delete the last created record
            WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
            Thread.sleep(4000);
            goToLastPageButton.click();
        }
        catch (Exception ex)
        {
            Assert.fail("Go to last page button not found");
        }
        Thread.sleep(7000);


        // click on the Delete Button
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        deleteButton.click();

        Thread.sleep(4000);

        //click OK to delete 
        driver.switchTo().alert().accept();

        Thread.sleep(3000);

        driver.navigate().refresh();

        Thread.sleep(4000);
        try
        {
            // Delete the last created record
            WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
            Thread.sleep(4000);
            goToLastPageButton.click();
        }
        catch (Exception ex)
        {
            Assert.fail("Go to last page button not found");
        }

        Thread.sleep(7000);
    }

    public String GetDeletedCode(WebDriver driver) throws InterruptedException {
        WebElement deletedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Thread.sleep(7000);
        return deletedCode.getText();
    }
}
