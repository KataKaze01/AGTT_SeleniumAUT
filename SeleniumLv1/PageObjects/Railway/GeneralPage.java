package Railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessage = By.xpath("//p[contains(@class,'message') and contains(@class,'error')]");
    private final By tabFAQ = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");

    //Elements
    protected WebElement getTablogin(){
        Utilities.waitForClickable(tabLogin);
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabRegister(){
        Utilities.waitForClickable(tabRegister);
        return Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getTablogout(){
        Utilities.waitForClickable(tabLogout);
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage(){
        Utilities.waitForClickable(lblWelcomeMessage);
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getLblErrorMessage(){
        Utilities.waitForClickable(lblErrorMessage);
        return Constant.WEBDRIVER.findElement(lblErrorMessage);}
    protected WebElement getTabFAQ(){
        Utilities.waitForClickable(tabFAQ);
        return Constant.WEBDRIVER.findElement((tabFAQ));}

    // Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessage(){
        return this.getLblErrorMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTablogin().click();
        return new LoginPage();
    }

    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public HomePage logout(){
        getTablogout().click();
        return new HomePage();
    }

    public FAQPage gotoFAQPage() {
        getTabFAQ().click();
        return new FAQPage();
    }
}
