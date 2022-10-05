package tests.automationExcercise;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.AutomationExcercise;
import utilities.Driver;

public class TestCase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Logout' button
    10. Verify that user is navigated to login page

 */
    //("jhjhsgsg1@gmail.com");
    //        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("1234");

    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().navigate().to("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        AutomationExcercise atmnEx=new AutomationExcercise();
        assert atmnEx.logo.isDisplayed();
        // 4. Click on 'Signup / Login' button
        atmnEx.singuplogin.click();
        //5. Verify 'Login to your account' is visible
        assert atmnEx.LoginToYourAccount.isDisplayed();
        // 6. Enter correct email address and password
atmnEx.emailAddress.sendKeys("jhjhsgsg1@gmail.com");
atmnEx.password.sendKeys("1234");
        //7. Click 'login' button
        atmnEx.login.click();
        //8. Verify that 'Logged in as username' is visible
        assert atmnEx.loggedinAs.isDisplayed();
        //9. Click 'Logout' button
        atmnEx.logout.click();
        //10. Verify that user is navigated to login page
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://automationexercise.com/login";
        Assert.assertEquals(actualUrl, expectedUrl);


    }
}
