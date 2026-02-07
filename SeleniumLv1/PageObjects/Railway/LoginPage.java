package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    public WebElement getTxtUsername(){
        Utilities.waitForVisible(_txtUsername);
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword(){
        Utilities.waitForVisible(_txtPassword);
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin(){
        Utilities.waitForClickable(_btnLogin);
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg(){
        Utilities.waitForVisible(_lblLoginErrorMsg);
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public HomePage login(String username, String password){
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();


        return new HomePage();
    }

    public HomePage login(UserAccount userAccount){
        getTxtUsername().sendKeys(userAccount.getUsernameAccount());
        getTxtPassword().sendKeys(userAccount.getPasswordAccount());
        getBtnLogin().click();


        return new HomePage();
    }
}