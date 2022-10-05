package tests.day18;

import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_Homework {
    @Test
    public void test01() {
        //https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hotelmycamp = new HmcPage();
        hotelmycamp.login.click();
        //test data username: manager ,
        //test data password : Manager1!
        hotelmycamp.userName.sendKeys(ConfigReader.getProperty("htlUserName"));
        hotelmycamp.password.sendKeys(ConfigReader.getProperty("htlPassword"));
        //log in butonuna basınız
        hotelmycamp.accountLogin.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        assert hotelmycamp.validLogin.isDisplayed();
       // Driver.closeDriver();
    }
}
