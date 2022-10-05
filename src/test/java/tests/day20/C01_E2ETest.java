package tests.day20;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_E2ETest {
    @Test(groups = "gp2")
    public void testName() throws InterruptedException {
        //https://www.hotelmycamp.com adresine git.
Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
//Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin
        hmcPage.userName.sendKeys(ConfigReader.getProperty("user"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).
                sendKeys(Keys.ENTER).perform();
//Username : manager
//Password  : Manager1!
//Login butonuna tıklayın.
//Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
            Thread.sleep(2000);
        hmcPage.hotelManagement.click();

        hmcPage.roomReservation.click();
        Thread.sleep(3000);
        hmcPage.addRoom.click();
//Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
//Save butonuna tıklayın.
        Faker faker = new Faker();
        hmcPage.idUser.sendKeys("manager", Keys.TAB,
                "Sea",Keys.TAB,
                "3",Keys.TAB,
                "10/05/2022",Keys.ENTER,Keys.TAB,Keys.TAB,
                "10/15/2022",Keys.ENTER,Keys.TAB,Keys.TAB,
                "2",Keys.TAB,
                "3",Keys.TAB,
                faker.name().fullName(),Keys.TAB,
                faker.phoneNumber().phoneNumber(),
                Keys.TAB,faker.internet().emailAddress(),
                Keys.TAB,"notes",
                Keys.TAB,Keys.SPACE,
                Keys.TAB,Keys.SPACE,
                Keys.TAB,Keys.SPACE);
//"RoomReservation was inserted successfully" textinin göründüğünü test edin.
        Thread.sleep(3000);
        Assert.assertTrue(hmcPage.roomReservationText.isDisplayed());
//OK butonuna tıklayın.
        hmcPage.okButton.click();

    }

}
