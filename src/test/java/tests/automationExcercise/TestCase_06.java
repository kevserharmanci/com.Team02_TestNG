package tests.automationExcercise;

import org.apache.commons.math3.ode.events.Action;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercise;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;

public class TestCase_06 {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
    */
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationEx"));


        //3. Verify that home page is visible successfully
        AutomationExcercise atmnEx = new AutomationExcercise();
        assert atmnEx.logo.isDisplayed();
        //4. Click on 'Contact Us' button
        atmnEx.contact_us.click();
        //5. Verify 'GET IN TOUCH' is visible
        assert atmnEx.getInTouc.isDisplayed();
        //6. Enter name, email, subject and message
        atmnEx.contact_usName.sendKeys(ConfigReader.getProperty("automationExName"));
        Actions actions =new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("autoEmail")).sendKeys(Keys.TAB).
                sendKeys("QA").sendKeys(Keys.TAB).sendKeys("TESTER").perform();
        //7. Upload file
        String dosyaYolu="C:\\Users\\user\\Desktop\\java sorular.pdf";
        atmnEx.dosyaSec.sendKeys(dosyaYolu);


        //8. Click 'Submit' button
        atmnEx.submit.click();
        //9. Click OK button
        Driver.getDriver().switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        assert atmnEx.succesMesaj.isDisplayed();
        //11. Click 'Home' button and verify that landed to home page successfully
        atmnEx.home.click();

       Assert.assertEquals(ConfigReader.getProperty("automationEx"),Driver.getDriver().getCurrentUrl());
        Driver.closeDriver();

    }
}
