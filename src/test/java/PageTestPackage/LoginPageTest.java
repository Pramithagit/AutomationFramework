package PageTestPackage;

import PageClassPackage.HomePage;
import PageClassPackage.LandingPage;
import PageClassPackage.LoginPage;
import com.BaseClassPackage.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

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
        home=new HomePage();
        login=new LoginPage();
        land= new LandingPage();
        home.VerifyLoginBtn();

    }
    @Test(priority = 1)
    public void Validatelogintitletest(){
        String actual=login.VerifyLoginTittle();
        String expected ="QA/QE/SDET Training.";
        Assert.assertEquals(expected,actual);

    }
    @Test(priority = 2)
    public void logintest(){
        land=login.loginmethod(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
