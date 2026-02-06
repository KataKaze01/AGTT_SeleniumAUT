package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPid = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By _lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By _lblRegisterSuccessMsg = By.xpath("//div[@id='content']/h1");
    private final By _lblPasswordErrorMsg = By.xpath("//input[@id='password']/following-sibling::label[contains(@class,'validation-error')]");
    private final By _lblPìdErrorMsg = By.xpath("//input[@id='pid']/following-sibling::label[contains(@class,'validation-error')]");

    public WebElement getTxtEmail(){
        Utilities.waitForVisible(_txtEmail);
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }

    public WebElement getTxtPassword(){
        Utilities.waitForVisible(_txtPassword);
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getTxtConfirmPassword(){
        Utilities.waitForVisible(_txtConfirmPassword);
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    public WebElement getTxtPid(){
        Utilities.waitForVisible(_txtPid);
        return Constant.WEBDRIVER.findElement(_txtPid);
    }

    public WebElement getBtnRegister(){
        Utilities.waitForClickable(_btnRegister);
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    protected WebElement getLblRegisterErrorMsg(){
        Utilities.waitForVisible(_lblRegisterErrorMsg);
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg);
    }

    protected WebElement getLblPasswordErrorMsg(){
        Utilities.waitForVisible(_lblPasswordErrorMsg);
        return Constant.WEBDRIVER.findElement(_lblPasswordErrorMsg);
    }

    protected WebElement getLblSuccessMsg(){
        Utilities.waitForVisible(_lblRegisterSuccessMsg);
        return Constant.WEBDRIVER.findElement(_lblRegisterSuccessMsg);
    }

    protected WebElement getLblPidErrorMsg(){
        Utilities.waitForVisible(_lblPìdErrorMsg);
        return Constant.WEBDRIVER.findElement(_lblPìdErrorMsg);
    }



    public String getPasswordErrorMsg(){return this.getLblPasswordErrorMsg().getText();}
    public String getPidErrorMsg(){return this.getLblPidErrorMsg().getText();}


    public HomePage register(UserAccount userAccount){
        getTxtEmail().sendKeys(userAccount.getUsernameAccount());
        getTxtPassword().sendKeys(userAccount.getPasswordAccount());
        getTxtConfirmPassword().sendKeys(userAccount.getPasswordAccount());
        getTxtPid().sendKeys((userAccount.getPidAccount()));

        getBtnRegister().click();

        return new HomePage();
    }
}
