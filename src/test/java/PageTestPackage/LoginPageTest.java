package PageTestPackage;

import PageClassPackage.HomePage;
import PageClassPackage.LandingPage;
import PageClassPackage.LoginPage;
import com.BaseClassPackage.BasePageTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import UtilsPackage.Utils;

public class LoginPageTest extends BasePageTest {

    private static Logger Log = LogManager.getLogger(LoginPageTest.class);
    HomePage home;
    LoginPage login;

    LandingPage land;

    //CREATING CONSTRUCTOR
    public LoginPageTest() {
        super();
    }
    @BeforeMethod
    public void setup(){
        initialization();
        Utils.setWebDriver(driver);
        home=new HomePage(driver);
        login=new LoginPage(driver);
        land= new LandingPage(driver);
        home.VerifyLoginBtn();

    }
    @Test()
    public void Validatelogintitletest(){
        String actual=login.VerifyLoginTittle();
        String expected ="QA/QE/SDET Training.";
        Assert.assertEquals(expected,actual);

    }
    @Test()
    public void logintest(){
        land=login.loginmethod(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
