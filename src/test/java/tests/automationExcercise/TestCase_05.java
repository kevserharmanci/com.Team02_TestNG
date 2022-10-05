package tests.automationExcercise;

import org.testng.annotations.Test;
import pages.AutomationExcercise;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase_05 {
    @Test
    public void test01() {
        //1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationEx"));
        AutomationExcercise atmnEx=new AutomationExcercise();

//3. Verify that home page is visible successfully
        assert atmnEx.logo.isDisplayed();
//4. Click on 'Signup / Login' button
        atmnEx.singuplogin.click();
//5. Verify 'New User Signup!' is visible

//6. Enter name and already registered emai;

//7. Click 'Signup' button
//8. Verify error 'Email Address already exist!' is visible

    }



}
