package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_Odev2 extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() {
        //Yeni bir Class Olusturun : C03_SoftAssert
//"http://zero.webappsecurity.com/" Adresine gidin
        driver.navigate().to("http://zero.webappsecurity.com");
//Sign in butonuna basin
driver.findElement(By.xpath("//*[@type='button']")).click();
//Login kutusuna "username" yazin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("username");
//Password kutusuna "password" yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
//Sign in tusuna basin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
//Online banking menusu icinde Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.cssSelector("#onlineBankingMenu")).click();
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
//"Purchase Foreign Currency" tusuna basin
        driver.findElement(By.cssSelector("a[href=\"#ui-tabs-3\"]")).click();
//"Currency" drop down menusunden Eurozone'u secin
        Select select =new Select(driver.findElement(By.cssSelector("#pc_currency")));
        select.selectByVisibleText("Eurozone (euro)");
//soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.cssSelector("option[value=\"EUR\"]")).isSelected());
//soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> options=select.getOptions();

        List<String> dropDown=new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)"));
        for (int i = 0; i < options.size(); i++){
            softAssert.assertTrue(options.get(i).getText().equals(dropDown.get(i)),i+". elementler uymuyor");

        }

// "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China  (yuan)",
// "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong  (dollar)",
// "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand  (dollar)","Sweden (krona)",
// "Singapore (dollar)","Thailand (baht)"
    }
}
