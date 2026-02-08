package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MailPage extends GeneralPage {

    private final By btnClickToEdit = By.xpath("//span[@id='inbox-id']");
    private final By txtText = By.xpath("//span[@id='inbox-id']//input[@type='text']");
    private final By btnSet = By.xpath("//button[@class='save button small']");
    private final By cbbScrambleAddress = By.xpath("//span[@id='alias-box']/input");
    private final By confirmEmail = By.xpath("//td[contains(., 'confirm')]");
    private final By confirmLinkAccount = By.xpath("//div[@class='email_body']//a[contains(@href, 'Account/Confirm')]");

    public WebElement getBtnClickToEdit(){
        Utilities.waitForVisible(btnClickToEdit);
        return Constant.WEBDRIVER.findElement(btnClickToEdit);
    }

    public WebElement getTxtText(){
        Utilities.waitForVisible(txtText);
        return Constant.WEBDRIVER.findElement(txtText);
    }

    public WebElement getBtnSet(){
        Utilities.waitForVisible(btnSet);
        return Constant.WEBDRIVER.findElement(btnSet);
    }

    public WebElement getCbbScrambleAddress(){
        Utilities.waitForVisible(cbbScrambleAddress);
        return Constant.WEBDRIVER.findElement(cbbScrambleAddress);
    }

    public WebElement getConfirmEmail(){
        Utilities.waitForVisible(confirmEmail);
        return Constant.WEBDRIVER.findElement(confirmEmail);
    }

    public WebElement getConfirmLinkAccount(){
//        Utilities.waitForVisible(confirmLinkAccount);
        return Constant.WEBDRIVER.findElement(confirmLinkAccount);
    }

    public MailPage open(){
        Constant.WEBDRIVER.navigate().to(Constant.GUERILLAMAIL_URL);
        return this;
    }

    public RegisterPage confirmMail(String emailAddress){
        String username = emailAddress.split("@")[0];
        getBtnClickToEdit().click();
        getTxtText().clear();
        getTxtText().sendKeys(username);
        getBtnSet().click();
//        getConfirmEmail().click();
        Utilities.waitForVisible(confirmEmail).click();
//        getConfirmLinkAccount().click();
        Utilities.waitForVisible(confirmLinkAccount).click();

        Utilities.switchToLatestWindow();

        return new RegisterPage();
    }
}