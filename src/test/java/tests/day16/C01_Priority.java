package tests.day16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C01_Priority extends TestBaseBeforeClassAfterClass {
    //youtube anasayfasina gidiniz
//asagidaki adlari kullanarak 4 testmethodu olusturun ve gerekli testleri yapınız
//titleTest() => sayfa baslıgının "YouTube oldugunu test ediniz
//imageTest(9 => YouTube resminin goruntulendigini(is.displayed()) test edin
//Search box'in erisilebilir oldugunu test edin(isEnabled())
//wrongTitleTest => Sayfa baslıgının "youtube olmadigini test ediniz

    @Test(groups = "gp1")
    public void youtubeTest1() {
        driver.get("https://youtube.com");

    }

    @Test(priority =1,dependsOnMethods = "youtubeTest1")
    public void titletest() {
        //titleTest() => sayfa baslıgının "YouTube oldugunu test ediniz
String actualtitle=driver.getTitle();
String expectedtitle="YouTube";
        Assert.assertEquals(actualtitle, expectedtitle);
        //2.cozum
        //assert !driver.getTitle().equals("youtube");

    }

    @Test(priority =2,dependsOnMethods = "youtubeTest1")
    public void imageTest() {
        //imageTest(9 => YouTube resminin goruntulendigini(is.displayed()) test edin
        assert driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed();



    }

    @Test(priority =3,dependsOnMethods = "youtubeTest1")
    public void wrongTitleTest() {
       // wrongTitleTest => Sayfa baslıgının "youtube olmadigini test ediniz

        assert !driver.getTitle().equals("youtube");
    }

    @Test(priority =4,dependsOnMethods = "youtubeTest1")
    public void Searcboxtest() {
        //Search box'in erisilebilir oldugunu test edin(isEnabled())
        assert driver.findElement(By.xpath("(//*[@id='search'])[2]")).isEnabled();

    }
}
