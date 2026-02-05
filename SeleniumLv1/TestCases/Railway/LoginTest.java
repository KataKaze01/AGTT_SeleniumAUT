    package Railway;

    import Common.Utilities;
    import Constant.Constant;
    import DataObjects_Railway.UserAccount;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class LoginTest extends BaseTest {

        @Test
        public void TC01(){
            System.out.println("TC01 - User can log into Railway with valid username and password");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "");
            homePage.open();

            System.out.println("2. Click on Login tab");
            LoginPage loginPage = homePage.gotoLoginPage();

            System.out.println("3. Enter valid Email and Password");
            System.out.println("4. Click on Login button");
            homePage = loginPage.login(userAccount);
            String actualMsg =  homePage.getWelcomeMessage();
            String expectedMsg = "Welcome " + Constant.USERNAME;

            Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        }

        @Test
        public void TC02(){
            System.out.println("TC02 - User cannot login with blank 'Username' textbox");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            UserAccount userAccount = new UserAccount("", Constant.PASSWORD, "");
            homePage.open();

            System.out.println("2. Click on Login tab");
            LoginPage loginPage = homePage.gotoLoginPage();

            System.out.println("3. User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox");
            System.out.println("4. Click on Login button");
            loginPage.login(userAccount);
            String actualMsg = loginPage.getErrorMessage();
            String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

            Assert.assertEquals(actualMsg, expectedMsg);
        }

        @Test
        public void TC03(){
            System.out.println("TC03 - User cannot log into Railway with invalid password");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            homePage.open();

            System.out.println("2. Click on 'Login' tab");
            LoginPage loginPage = homePage.gotoLoginPage();

            System.out.println("3. Enter valid Email and invalid Password");
            System.out.println("4. Click on Login button");
            String invalidPassword  = Utilities.generateRandomString(8);
            UserAccount userAccount = new UserAccount(Constant.USERNAME, invalidPassword, "");
            loginPage.login(userAccount);

            String actualMsg = loginPage.getLblLoginErrorMsg().getText();
            String expectedMsg = "There was a problem with your login and/or errors exist in your form. ";

            Assert.assertEquals(actualMsg, expectedMsg);
        }

        @Test
        public void TC04(){
            System.out.println("TC04 - System shows message when user enters wrong password many times");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            homePage.open();

            System.out.println("2. Click on \"Login\" tab");
            LoginPage loginPage = homePage.gotoLoginPage();
            String invalidPassword = Utilities.generateRandomString(8);

            System.out.println("3. Enter valid information into \"Username\" textbox except \"Password\" textbox.");
            System.out.println("4. Click on \"Login\" button");
            System.out.println("5. Repeat step 3 and 4 three more times.");
            for (int i = 1; i < 4; i++){
                System.out.println("Login attempt: " + i);

                loginPage.getTxtUsername().clear();
                loginPage.getTxtUsername().sendKeys(Constant.USERNAME);
                loginPage.getTxtPassword().clear();
                loginPage.getTxtPassword().sendKeys(invalidPassword);

                loginPage.getBtnLogin().click();
            }

            String actualMsg = loginPage.getLblLoginErrorMsg().getText();
            String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

            Assert.assertEquals(actualMsg, expectedMsg, "Login attempt warning message is not displayed as expected");
        }

        @Test
        public void TC05(){
            System.out.println("TC05 - User can't login with an account hasn't been activated");
            System.out.println("Pre-condition: a not-active account is existing");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            homePage.open();

            System.out.println("2. Click on \"Login\" tab");
            LoginPage loginPage = homePage.gotoLoginPage();

            System.out.println("3. Enter username and password of account hasn't been activated.");
            System.out.println("4. Click on \"Login\" button");
            UserAccount userAccount = new UserAccount("accclone1223@spam4.me", "12345678", "");
            loginPage.login(userAccount);

            String actualMsg = loginPage.getLblLoginErrorMsg().getText();
            String expectedMsg = "Invalid username or password. Please try again.";

            Assert.assertEquals(actualMsg, expectedMsg);
        }

        @Test
        public void TC06(){
            System.out.println("TC06 - User is redirected to Home page after logging out");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            homePage.open();

            System.out.println("2. Login with valid Email and Password");
            LoginPage loginPage = homePage.gotoLoginPage();
            UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "");
            loginPage.login(userAccount);

            FAQPage faqPage = homePage.gotoFAQPage();

            homePage = faqPage.logout();

        }

        @Test
        public void TC07(){
            System.out.println("TC07 - User can't create account with an already in-use email");


        }
    }