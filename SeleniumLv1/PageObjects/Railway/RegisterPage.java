package Railway;

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
    private final By _lblPasswordErrorMsg = By.xpath("//input[@id='password']/following-sibling::label[contains(@class,'validation-error')]");
    private final By _lblPìdErrorMsg = By.xpath("//input[@id='pid']/following-sibling::label[contains(@class,'validation-error')]");

    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getTxtPid(){
        return Constant.WEBDRIVER.findElement(_txtPid);
    }
    public WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    protected WebElement getLblRegisterErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg);
    }
    protected WebElement getLblPasswordErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblPasswordErrorMsg);
    }
    protected WebElement getLblPidErrorMsg(){
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
