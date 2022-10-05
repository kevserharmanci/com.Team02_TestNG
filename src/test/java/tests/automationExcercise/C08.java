package tests.automationExcercise;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AutomationExcercise;
import utilities.ConfigReader;
import utilities.Driver;

public class C08 {
    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationEx"));

        //3. Verify that home page is visible successfully
        AutomationExcercise atmnEx = new AutomationExcercise();
        assert atmnEx.logo.isDisplayed();
        assert Driver.getDriver().getTitle().equals("Automation Exercise");

        //4. Click on 'Products' button

        atmnEx.products.click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Driver.getDriver().getTitle().contains("All Products");
        //6. The products list is visible
        assert atmnEx.allproducts.isDisplayed();
        //7. Click on 'View Product' of first product
        atmnEx.ilkUrun.click();
        //8. User is landed to product detail page
        Driver.getDriver().getCurrentUrl().contains("Product Details");
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        System.out.println("atmnEx.ilkUrunGörüntü.getText() = " + atmnEx.ilkUrunGörüntü.getText());
        assert atmnEx.ilkUrunGörüntü.isDisplayed();
    }
}
