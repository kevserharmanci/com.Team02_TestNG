package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExcercise {
    public AutomationExcercise() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@src='/static/images/home/logo.png']")
    public WebElement logo;


    @FindBy(xpath = "//*[@href='/login']")
    public WebElement singuplogin;


    @FindBy(xpath = "//*[@type='text']")

    public WebElement name;


    @FindBy(xpath = "(//*[@type='email'])[2]")
    public WebElement nameEmail;


    @FindBy(xpath = "//*[@text()=['New User Signup!']")
    public WebElement sagdakiSignup;


    @FindBy(xpath = "(//h2)[1]")
    public WebElement LoginToYourAccount;


    @FindBy(xpath = "(//*[@type='email'])[1]")
    public WebElement emailAddress;

    @FindBy(xpath = "(//*[@type='password'])[1]")
    public WebElement password;


    @FindBy(xpath = "(//*[@type='submit'])[1]")
    public WebElement login;

    @FindBy(xpath = "//*[@text='Logged in as']")
    public WebElement loggedinAs;


    @FindBy(xpath = "//*[@href='/logout']")
    public WebElement logout;

    @FindBy(xpath = "//*[@text()=['Email Addres!']")
    public WebElement newUserSingup;

    @FindBy(xpath = "//*[@href='/contact_us']")
    public WebElement contact_us;
//(//*[@class='title text-center'])[2]
@FindBy(xpath = "(//*[@class='title text-center'])[2]")
public WebElement getInTouc;
//(//*[@type='text'])[1]
@FindBy(xpath = "//*[@name='name']")
public WebElement contact_usName;
    @FindBy(xpath = "//*[@type='file']")
    public WebElement dosyaSec;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submit;
    @FindBy(xpath = "//*[@class='status alert alert-success']")
    public WebElement succesMesaj;
    @FindBy(xpath = "//*[@href='/products']")
    public WebElement products;
    @FindBy(xpath = "//*[@class='fa fa-angle-double-left']")
    public WebElement home;
    @FindBy(xpath = "//*[@class='title text-center']")
    public WebElement allproducts;

    @FindBy(xpath = "//*[@href='/product_details/1']")
    public WebElement ilkUrun;
    @FindBy(xpath = "//*[@class='product-information']")
    public WebElement ilkUrunGörüntü;


}

