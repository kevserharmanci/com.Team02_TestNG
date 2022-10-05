package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_Odev01 {
    //Bir class oluşturun: DependsOnTest
//https://www.amazon.com/ adresine gidin.
//Test : Amazon ana sayfaya gittiginizi test edin
//Test : 1.Test basarili ise search Box'i kullanarak "Nutella" icin
//arama yapin ve aramanizin gerceklestigini Test edin
//Test : "Nutella" icin arama yapildiysa ilk urunu tiklayin ve fiyatinin(//*[@s='s-image'])[1] ,,,//*[@title='See All Buying Options']
//$16.83 oldugunu test edin
    @Test(groups = "gp1")
    public void test01() {

        //https://www.amazon.com/ adresine gidin.
        Driver.getDriver().get("https://www.amazon.com/");
        //Test : Amazon ana sayfaya gittiginizi test edin
        assert Driver.getDriver().getCurrentUrl().contains("https://www.amazon.com/");

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //Test : 1.Test basarili ise search Box'i kullanarak "Nutella" icin
        //arama yapin ve aramanizin gerceklestigini Test edin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.searchBox.sendKeys("Nutella", Keys.ENTER);
        assert amazonPage.resultText.isDisplayed();
        //Test : "Nutella" icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
        //$16.83 oldugunu test edin
        Driver.getDriver().findElement(By.cssSelector("img[class=\"s-image\"]")).click();
        Driver.getDriver().findElement(By.cssSelector("a[title=\"See All Buying Options\"]")).click();
        assert !Driver.getDriver().findElement(By.cssSelector("div[id=\"aod-price-1\"]")).
                getText().equals("$16.83");

        Assert.assertNotEquals(Driver.getDriver().findElement(By.cssSelector("div[id=\"aod-price-1\"]")).
                getText(), "$16.83");

    }
}
